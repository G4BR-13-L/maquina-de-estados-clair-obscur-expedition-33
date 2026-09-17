package combate

import atores.Combatente
import combate.estados.ExecutandoHabilidade
import combate.estados.Neutro
import combate.estados.SelecaoDeAcao

class Turno (val combatenteEmBatalha: CombatenteEmBatalha){

    var estado: EstadoTurno = Neutro()

    fun transicionar(estado: EstadoTurno) {
        if (estado is Neutro) {
            this.estado = SelecaoDeAcao()
        }

        if (estado is SelecaoDeAcao) {
            this.estado = SelecaoDeAcao()
        }
    }

    fun executarHabilidade(habilidade: Habilidade, paDisponivel: Int) {
        if (this.estado is SelecaoDeAcao) {
            this.estado = ExecutandoHabilidade()
        }
    }

}
