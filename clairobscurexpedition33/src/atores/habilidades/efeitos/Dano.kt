package atores.habilidades.efeitos

import atores.habilidades.Elemento

data class Dano(
    val poderBase: Int,
    val elemento: Elemento = Elemento.FISICO,
    val escalaComForca: Boolean = true
) : Efeito