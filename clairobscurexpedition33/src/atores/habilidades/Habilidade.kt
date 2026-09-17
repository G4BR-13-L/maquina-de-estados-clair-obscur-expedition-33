package atores.habilidades

import atores.habilidades.efeitos.Dano
import atores.habilidades.efeitos.Efeito
import atores.habilidades.efeitos.ModificarPostura
import atores.habilidades.efeitos.ModificarStatus

data class Habilidade(
    val id: Int,
    val nome: String,
    val custoPA: Int,
    val tipoAlvo: TipoAlvo,
    val janelaQteMilisegundos: Int = 300,
    val bonusAcertoQte: Double = 1.5, // 50% extra de dano/cura se acertar o QTE
    val efeitos: List<Efeito>
)

enum class Elemento {
    FISICO, FOGO, GELO, LUZ, SOMBRA
}

enum class TipoAlvo {
    UM_INIMIGO,
    TODOS_OS_INIMIGOS,
    UM_ALIADO,
    TODOS_OS_ALIADOS,
    PROPRIO_CONJURADOR,
}

object CatalogoHabilidades {
    // Golpe direto simples
    val corteRapido = Habilidade(
        id = 1,
        nome = "Corte Rápido",
        custoPA = 2,
        tipoAlvo = TipoAlvo.UM_INIMIGO,
        janelaQteMilisegundos = 250,
        efeitos = listOf(
            Dano(poderBase = 25, elemento = Elemento.FISICO)
        )
    )

    // Habilidade híbrida: Postura Virtuosa da Maelle (+200% de dano, mas vida cai para 1)
    val posturaVirtuosa = Habilidade(
        id = 2,
        nome = "Postura Virtuosa",
        custoPA = 3,
        tipoAlvo = TipoAlvo.PROPRIO_CONJURADOR,
        efeitos = listOf(
            ModificarPostura(nomePostura = "Virtuosa", vidaFixa = 1),
            ModificarStatus(atributo = "forca", multiplicadorPercentual = 2.0, duracaoTurnos = 2)
        )
    )

    val incendio = Habilidade(
        id = 3,
        nome = "Incêndio",
        custoPA = 3,
        tipoAlvo = TipoAlvo.TODOS_OS_INIMIGOS,
        efeitos = listOf(
            Dano(poderBase = 35, elemento = Elemento.FOGO)
        )
    )
}

