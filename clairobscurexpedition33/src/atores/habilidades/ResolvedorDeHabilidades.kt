package atores.habilidades

import atores.habilidades.efeitos.Cura
import atores.habilidades.efeitos.Dano
import atores.habilidades.efeitos.Efeito
import atores.habilidades.efeitos.ModificarPostura
import atores.habilidades.efeitos.ModificarStatus
import combate.CombatenteEmBatalha

class ResolvedorDeHabilidades {

    fun aplicarHabilidade(
        habilidade: Habilidade,
        conjurador: CombatenteEmBatalha,
        alvos: List<CombatenteEmBatalha>,
        acertouQte: Boolean
    ) {
        // Desconta o custo de recurso
        conjurador.PA -= habilidade.custoPA
        val multiplicadorQte = if (acertouQte) habilidade.bonusAcertoQte else 1.0

        for (efeito in habilidade.efeitos) {
            when (efeito) {
                is Dano -> {
                    val atributoAtaque = if (efeito.escalaComForca) conjurador.combatente.forca else conjurador.combatente.agilidade
                    val danoBruto = (efeito.poderBase + atributoAtaque) * multiplicadorQte

                    alvos.forEach { alvo ->
                        val danoFinal = (danoBruto - alvo.combatente.defesa).coerceAtLeast(1.0).toInt()
                        alvo.vida = (alvo.vida - danoFinal).coerceAtLeast(0)
                    }
                }

                is Cura -> {
                    val curaFinal = (efeito.valorBase * multiplicadorQte).toInt()
                    alvos.forEach { alvo ->
                        alvo.vida = (alvo.vida + curaFinal).coerceAtMost(alvo.combatente.vida)
                    }
                }

                is ModificarStatus -> {
                    // Aplica buffers temporários nas listas de status dos alvos
                }

                is ModificarPostura -> {
                    efeito.vidaFixa?.let { novaVida ->
                        conjurador.vida = novaVida
                    }
                }
            }
        }
    }
}