package atores.habilidades.efeitos

data class Cura(
    val valorBase: Int,
    val escalaComMagia: Boolean = true
) : Efeito