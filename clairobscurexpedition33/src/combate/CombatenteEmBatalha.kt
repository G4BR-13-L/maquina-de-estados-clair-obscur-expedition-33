package combate

import atores.Combatente

class CombatenteEmBatalha<T : Combatente>(combatente: Combatente) {
    val combatente: Combatente = combatente
    var vida = combatente.vida
    var PA = 1
}