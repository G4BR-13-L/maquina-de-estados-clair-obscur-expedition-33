package factories

import atores.Expedicionario
import atores.Inimigo
import combate.CombatenteEmBatalha
import combate.Batalha

internal class BatalhaFactory(private val expedicionarios: List<Expedicionario>, private val inimigos: List<Inimigo>) {

    fun build() : Batalha {
        var expedicionariosEmBatalha: ArrayList<CombatenteEmBatalha<Expedicionario>> = arrayListOf();
        for (expedicionario in expedicionarios) {
            val expedicionarioEmBatalha = CombatenteEmBatalha<Expedicionario>(expedicionario);
            expedicionariosEmBatalha.add(expedicionarioEmBatalha)
        }

        var inimigosEmBatalha: ArrayList<CombatenteEmBatalha<Inimigo>> = arrayListOf();
        for (inimigo in inimigos) {
            val inimigoEmBatalha: CombatenteEmBatalha<Inimigo> = CombatenteEmBatalha<Inimigo>(inimigo);
            inimigosEmBatalha.add(inimigoEmBatalha)
        }

        return Batalha(expedicionariosEmBatalha, inimigosEmBatalha)
    }
}