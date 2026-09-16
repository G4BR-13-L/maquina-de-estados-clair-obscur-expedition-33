package combate.estados

import EstadoTurno

internal class SelecaoDeAcao(var personagemAtivoId: Int, var paDisponivel: Int) : EstadoTurno

internal class ExecutandoHabilidade(var personagemAtivoId: Int, var habilidadeId: Int, var janelaQteMilisegundos: Int) :
    EstadoTurno

internal class TurnoInimigoAtacando(var inimigoId: Int, var alvoId: Int, var janelaParryMilisegundos: Int) : EstadoTurno

internal class FimDeCombate(var vitoria: Boolean) : EstadoTurno