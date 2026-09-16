package combate

import CombatenteEmBatalha
import EstadoTurno
import combate.eventos.EventoCombate
import Expedicionario
import Inimigo

class Batalha(val expedicionariosEmBatalha: List<CombatenteEmBatalha<Expedicionario>>,
                       val inimigosEmBatalha: List<CombatenteEmBatalha<Inimigo>>) {

    fun transicionar(estadoAtual: EstadoTurno?, eventoCombate: EventoCombate?): EstadoTurno? {
        return null // temporario
    }
}