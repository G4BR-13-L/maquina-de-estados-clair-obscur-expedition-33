package atores.habilidades.efeitos

data class ModificarStatus(
    val atributo: String,
    val multiplicadorPercentual: Double,
    val duracaoTurnos: Int
) : Efeito