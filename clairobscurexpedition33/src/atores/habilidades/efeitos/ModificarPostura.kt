package atores.habilidades.efeitos

data class ModificarPostura(
    val nomePostura: String,
    val vidaFixa: Int? = null // Ex: Postura virtuosa da Maelle que fixa em 1 HP
) : Efeito