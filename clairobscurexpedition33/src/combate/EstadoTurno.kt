package combate

import atores.habilidades.Habilidade

sealed interface EstadoTurno {
    object Neutro : EstadoTurno
    object SelecaoDeAcao : EstadoTurno
    data class ExecutandoAcao(val habilidade: Habilidade) : EstadoTurno
    object Finalizado : EstadoTurno
}