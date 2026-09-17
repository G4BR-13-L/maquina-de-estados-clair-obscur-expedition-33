package combate

import atores.Combatente
import atores.Expedicionario
import atores.Inimigo
import atores.Time

class CombatenteEmBatalha(combatente: Combatente, time: Time) {
    val combatente: Combatente = combatente
    var vida = combatente.vida
    var PA = 1
}