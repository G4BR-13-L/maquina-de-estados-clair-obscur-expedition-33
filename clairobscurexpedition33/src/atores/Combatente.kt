package atores

abstract class Combatente(var id: Int, var nome: String) {
    var nivel = 0;
    var vida: Int = 0
    var forca: Int = 0
    var defesa: Int = 0
    var sorte: Int = 0
    var agilidade: Int = 0
}