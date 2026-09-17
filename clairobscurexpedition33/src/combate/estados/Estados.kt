package combate.estados

import combate.EstadoTurno

internal class TurnoInimigoAtacando(var inimigoId: Int, var alvoId: Int, var janelaParryMilisegundos: Int) : EstadoTurno

internal class FimDeCombate(var vitoria: Boolean) : EstadoTurno