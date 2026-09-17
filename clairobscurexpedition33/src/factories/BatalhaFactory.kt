package factories

import atores.Combatente
import atores.Expedicionario
import atores.Inimigo
import atores.Time
import combate.CombatenteEmBatalha
import combate.Batalha

internal class BatalhaFactory(private val expedicionarios: List<Expedicionario>, private val inimigos: List<Inimigo>) {

    fun build(): Batalha {
        var listCombatenteEmBatalha: ArrayList<CombatenteEmBatalha> = arrayListOf();
        for (expedicionario in expedicionarios) {
            val expedicionarioEmBatalha = CombatenteEmBatalha(expedicionario, Time.EXPEDICAO33);
            listCombatenteEmBatalha.add(expedicionarioEmBatalha)
        }

        for (inimigo in inimigos) {
            val inimigoEmBatalha: CombatenteEmBatalha = CombatenteEmBatalha(inimigo, Time.INIMIGO);
            listCombatenteEmBatalha.add(inimigoEmBatalha)
        }

        var combatentes: ArrayList<Combatente> = arrayListOf()
        combatentes.addAll(expedicionarios)
        combatentes.addAll(inimigos)

        var turnos = GeradorDeTurnos().gerarTurnos(combatentes)

        return Batalha(combatenteEmBatalhas, inimigosEmBatalha, turnos)
    }
}