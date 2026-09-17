package combate

import atores.habilidades.Habilidade

class Turno(val combatente: CombatenteEmBatalha) {

    var estado: EstadoTurno = EstadoTurno.Neutro
        private set

    fun iniciar() {
        if (estado is EstadoTurno.Neutro) {
            combatente.PA = (combatente.PA + 1).coerceAtMost(5)
            estado = EstadoTurno.SelecaoDeAcao
        }
    }

    fun prepararHabilidade(habilidade: Habilidade): Boolean {
        if (estado is EstadoTurno.SelecaoDeAcao && combatente.PA >= habilidade.custoPA) {
            estado = EstadoTurno.ExecutandoAcao(habilidade)
            return true
        }
        return false
    }

    fun finalizar() {
        estado = EstadoTurno.Finalizado
    }
}