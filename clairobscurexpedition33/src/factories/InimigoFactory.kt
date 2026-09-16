package factories

import atores.Inimigo
import utils.Utils

internal class InimigoFactory {
    fun buildByNivel(nivel: Int): Inimigo {
        var id: Int = Utils().randomInt()
        var nome: String = Utils().randomNome()
        var inimigo: Inimigo = Inimigo(id, nome)

        inimigo.nivel = nivel

        inimigo.agilidade = nivel
        inimigo.forca = nivel
        inimigo.defesa = nivel
        inimigo.sorte = nivel
        inimigo.vida = nivel

        return inimigo
    }
}