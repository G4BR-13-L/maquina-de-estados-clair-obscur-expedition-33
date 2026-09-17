package combate

import combate.eventos.EventoCombate
import atores.Expedicionario
import atores.Inimigo
import combate.estados.ExecutandoHabilidade
import combate.estados.Neutro
import combate.estados.SelecaoDeAcao
import java.util.LinkedList
import kotlin.math.log

class Batalha(
) {

    lateinit var listCombatenteEmBatalha: List<CombatenteEmBatalha>
    lateinit var turnos: LinkedList<Turno>
    lateinit var turnoAtual: Turno

    constructor(listCombatenteEmBatalha: List<CombatenteEmBatalha>, turnos: LinkedList<Turno>) : this() {
        if (listCombatenteEmBatalha.isEmpty()){
            throw IllegalArgumentException("combatenteEmBatalha must not be empty")
        }

        if (turnos.isEmpty()){
            throw IllegalArgumentException("combatenteEmBatalha must not be empty")
        }

        this.turnoAtual = turnos.first()
        this.listCombatenteEmBatalha = listCombatenteEmBatalha
        this.turnos = turnos
    }

    fun transicionar(turno: Turno) {
        if (turnoAtual.estado is SelecaoDeAcao){
            println("Aguardando seleção de ação")
        }
    }

    fun conjurarHabilidade(turno: Turno,
                           combatente: CombatenteEmBatalha,
                           habilidade: Habilidade,
                           inimigo: CombatenteEmBatalha
    ) {
        if (turnoAtual.estado is SelecaoDeAcao){
            if (combatente.PA >= habilidade.custoPA){
                turno.estado = ExecutandoHabilidade()
                combatente.PA -= habilidade.custoPA
                if(habilidade.isCausaDano){
                    var dano = habilidade.dano
                    inimigo.vida -= dano
                }
            }
        }
    }
}

