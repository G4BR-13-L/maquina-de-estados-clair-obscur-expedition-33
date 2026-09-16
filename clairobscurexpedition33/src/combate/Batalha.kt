package combate

import combate.eventos.EventoCombate
import atores.Expedicionario
import atores.Inimigo

class Batalha(val expedicionariosEmBatalha: List<CombatenteEmBatalha<Expedicionario>>,
                       val inimigosEmBatalha: List<CombatenteEmBatalha<Inimigo>>) {

    fun transicionar(estadoAtual: EstadoTurno?, eventoCombate: EventoCombate?): EstadoTurno? {
        return null // temporario
    }
}