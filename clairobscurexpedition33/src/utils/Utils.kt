package utils

internal class Utils {

    fun randomInt(): Int {
        return randomIntInRange(0, 255);
    }

    fun randomIntInRange(min: Int, max: Int): Int {
        return (min..max).random()
    }

    fun randomNome(): String {
        val nomes = listOf(
            "Rise Radiant", "Mastodon", "E=mc²", "Marx", "Lovecraft",
            "Ritmo", "Ritual", "Responsa", "Rust", "Kotlin", "Gemenei",
            "Eveque", "Burgeon", "Vedo", "Diver Drive", "Star Platinum", "TMNT"
        )
        return nomes.random() // Seguro e sem sorteio manual de índice
    }
}