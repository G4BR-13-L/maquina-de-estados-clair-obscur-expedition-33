package utils

internal class Utils {

    fun randomInt(): Int {
        return randomIntInRange(0, 255);
    }

    fun randomIntInRange(min: Int, max: Int): Int {
        return (min..max).random()
    }

    fun randomNome(): String {
        var nomes: List<String> = listOf(
            "Rise Radiant",
            "Mastodon",
            "E=mc²",
            "Marx",
            "Lovecraft",
            "Ritmo",
            "Ritual",
            "Responsa",
            "Rust",
            "Kotlin",
            "Gemenei",
            "Eveque",
            "Burgeon",
            "Vedo",
            "Diver Drive",
            "Star Platinum",
            "TMNT"
        )

        var indice: Int = randomIntInRange(0, nomes.size - 1)
        return nomes.get(indice);
    }
}