package combate

import atores.Combatente
import atores.Expedicionario
import atores.Inimigo
import atores.Time

class CombatenteEmBatalha(
    val combatente: Combatente,
    val time: Time,
    var vida: Int = combatente.vida,
    var PA: Int = 1
)