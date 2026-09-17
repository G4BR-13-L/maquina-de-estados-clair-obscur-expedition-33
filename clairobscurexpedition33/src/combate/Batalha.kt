package combate

import atores.Time
import atores.habilidades.Habilidade
import atores.habilidades.ResolvedorDeHabilidades
import factories.GeradorDeTurnos

class Batalha(
    val combatentes: List<CombatenteEmBatalha>,
    var filaDeTurnos: MutableList<Turno>
) {
    var turnoAtual: Turno = filaDeTurnos.first()
    var fimDeBatalha: Boolean = false

    fun executarAcao(habilidade: Habilidade, alvos: List<CombatenteEmBatalha>, acertouQte: Boolean = true) {
        if (fimDeBatalha) return

        // 1. O Turno valida a transição da própria FSM
        val autorizado = turnoAtual.prepararHabilidade(habilidade)
        if (!autorizado) {
            println("Ação inválida: PA insuficiente ou estado incorreto.")
            return
        }

        // 2. A Batalha orquestra a resolução (o Resolvedor cuida de descontar o PA e aplicar dano)
        ResolvedorDeHabilidades().aplicarHabilidade(
            habilidade = habilidade,
            conjurador = turnoAtual.combatente,
            alvos = alvos,
            acertouQte = acertouQte
        )

        // 3. Finaliza a FSM do turno atual
        turnoAtual.finalizar()

        // 4. Checa mortes e condições de término
        val houveMortes = alvos.any { it.vida <= 0 }
        verificarFimDeCombate()

        if (!fimDeBatalha) {
            if (houveMortes) {
                recalcularLinhaDoTempo()
            }
            avancarProximoTurno()
        }
    }

    fun recalcularLinhaDoTempo() {
        val vivos = combatentes.filter { it.vida > 0 }
        filaDeTurnos.clear()
        filaDeTurnos.addAll(GeradorDeTurnos().gerarTurnos(vivos, quantidadeTurnos = 20))
    }

    private fun avancarProximoTurno() {
        if (filaDeTurnos.isNotEmpty()) {
            filaDeTurnos.removeAt(0)
        }
        if (filaDeTurnos.isEmpty()) {
            recalcularLinhaDoTempo()
        }

        // Descarta turnos de quem morreu antes da vez
        while (filaDeTurnos.isNotEmpty() && filaDeTurnos.first().combatente.vida <= 0) {
            filaDeTurnos.removeAt(0)
        }

        if (filaDeTurnos.isNotEmpty()) {
            turnoAtual = filaDeTurnos.first()
            turnoAtual.iniciar()
        }
    }

    private fun verificarFimDeCombate() {
        val aliadosVivos = combatentes.any { it.time == Time.EXPEDICAO33 && it.vida > 0 }
        val inimigosVivos = combatentes.any { it.time == Time.INIMIGO && it.vida > 0 }

        if (!inimigosVivos) {
            fimDeBatalha = true
            println("Vitória da Expedição 33!")
        } else if (!aliadosVivos) {
            fimDeBatalha = true
            println("Derrota: A Expedição sucumbiu.")
        }
    }
}