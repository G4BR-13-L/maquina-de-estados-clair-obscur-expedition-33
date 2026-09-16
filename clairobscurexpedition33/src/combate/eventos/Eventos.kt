package combate.eventos

interface EventoCombate

internal class AcertarQteAtaque : EventoCombate

internal class ErrarQteAtaque : EventoCombate

internal class AcertarParry : EventoCombate

internal class ReceberDano : EventoCombate

internal class InimigoMorto : EventoCombate

internal class JogadorMorto : EventoCombate

internal class SelecionarHabilidade(var habilidadeId: Int, var custoPa: Int) : EventoCombate