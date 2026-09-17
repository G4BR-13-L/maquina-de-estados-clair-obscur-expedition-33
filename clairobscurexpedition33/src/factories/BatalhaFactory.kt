package factories

import atores.Combatente
import atores.Expedicionario
import atores.Inimigo
import atores.Time
import combate.CombatenteEmBatalha
import combate.Batalha

internal class BatalhaFactory(
    private val expedicionarios: List<Expedicionario>,
    private val inimigos: List<Inimigo>
) {
    fun build(): Batalha {
        val aliadosEmBatalha = expedicionarios.map { CombatenteEmBatalha(it, Time.EXPEDICAO33) }
        val inimigosEmBatalha = inimigos.map { CombatenteEmBatalha(it, Time.INIMIGO) }

        val todosCombatentes = aliadosEmBatalha + inimigosEmBatalha
        val turnosIniciais = GeradorDeTurnos().gerarTurnos(todosCombatentes).toMutableList()

        return Batalha(todosCombatentes, turnosIniciais).apply {
            turnoAtual.iniciar()
        }
    }
}