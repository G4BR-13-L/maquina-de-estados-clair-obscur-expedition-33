internal class Expedition33Factory {
    fun build(): Expedidion33 {
        var lune: Expedicionario = Expedicionario(1, "Lune")
        var sciel: Expedicionario = Expedicionario(2, "Sciel")
        var maelle: Expedicionario = Expedicionario(3, "Maelle")
        var verso: Expedicionario = Expedicionario(4, "Verso")
        var gustave: Expedicionario = Expedicionario(5, "Gustave")
        var monoco: Expedicionario = Expedicionario(6, "Monoco")

        val map: Map<Int, Expedicionario> = mapOf(
            lune.id to lune,
            sciel.id to sciel,
            maelle.id to maelle,
            verso.id to verso,
            gustave.id to gustave,
            monoco.id to monoco
        )

        return Expedidion33(map)
    }
}