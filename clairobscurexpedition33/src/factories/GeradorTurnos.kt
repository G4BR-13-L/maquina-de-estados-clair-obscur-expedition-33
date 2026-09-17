package factories

import atores.Combatente
import combate.CombatenteEmBatalha
import combate.Turno
import kotlin.random.Random

class GeradorDeTurnos(private val random: Random = Random.Default) {

    private class EstadoCombatente(
        val combatenteEmBatalha: CombatenteEmBatalha,
        var pesoAtual: Int
    )

    fun gerarTurnos(combatentes: List<CombatenteEmBatalha>, quantidadeTurnos: Int = 20): List<Turno> {
        require(combatentes.isNotEmpty()) { "A lista de combatentes não pode ser vazia" }

        // Inicializa o peso de cada um com sua agilidade base
        val estados = combatentes.map { EstadoCombatente(it, it.combatente.agilidade) }

        return List(quantidadeTurnos) {
            val escolhido = sortearComPesos(estados)
            atualizarPesos(estados, escolhido)
            Turno(escolhido.combatenteEmBatalha)
        }
    }

    private fun sortearComPesos(estados: List<EstadoCombatente>): EstadoCombatente {
        val pesoTotal = estados.sumOf { it.pesoAtual }
        var roll = random.nextInt(pesoTotal)

        for (estado in estados) {
            if (roll < estado.pesoAtual) {
                return estado
            }
            roll -= estado.pesoAtual
        }

        return estados.last() // Fallback de precisão
    }

    private fun atualizarPesos(estados: List<EstadoCombatente>, escolhido: EstadoCombatente) {
        for (estado in estados) {
            if (estado === escolhido) {
                // Quem jogou: zera ou reduz o peso (ex: volta a 0)
                estado.pesoAtual = 0
            } else {
                // Quem não jogou: acumula urgência somando sua agilidade base
                estado.pesoAtual += estado.combatenteEmBatalha.combatente.agilidade
            }
        }
    }
}