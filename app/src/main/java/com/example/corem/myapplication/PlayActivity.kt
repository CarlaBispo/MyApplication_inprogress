package com.example.corem.myapplication

import android.media.JetPlayer
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_play.*
import java.util.Random

class PlayActivity : AppCompatActivity() {

    private var numeroAleatorio: Random? = null

    private val AMARELO = 1
    private val AZUL = 2
    private val ROSA = 3

    private val totalVitoria = 0
    private val totalEmpate = 0
    private val totalDerrota = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        numeroAleatorio = Random()

        btAmarelo.setOnClickListener{
           ivJogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.poke_amarelo))
            realizarJogada(AMARELO)
        }


        btAzul.setOnClickListener{
            ivJogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.poke_azul))
            realizarJogada(AZUL)
        }


        btRosa.setOnClickListener{
            ivJogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.poke_rosa))
            realizarJogada(ROSA)
        }
    }

    private fun realizarJogada(jogadaPlayer: Int){

        val player = MediaPlayer.create(this, R.raw.spell_00)
        player.start()

        val jogadaBot = numeroAleatorio!!.nextInt(3)+1
        when(jogadaBot){

            AMARELO->{
                ivJogadaBot!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.poke_amarelo))
                when(jogadaPlayer){
                    AZUL -> venceu()
                    AMARELO -> empatou()
                    ROSA -> perdeu()
                }
            }
            AZUL ->{
                ivJogadaBot!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.poke_azul))
            when(jogadaPlayer){
                AZUL -> empatou()
                AMARELO -> perdeu()
                ROSA -> venceu()
                }
            }
            ROSA ->{
                ivJogadaBot!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.poke_rosa))
                when(jogadaPlayer){
                    AZUL -> perdeu()
                    AMARELO -> venceu()
                    ROSA -> empatou()
                }
            }

        }
    }

    private fun venceu(){
        tvResultado.text="Venceu"
        tvResultado.setTextColor(ContextCompat.getColor(this,R.color.vitoria))
    }

    private fun perdeu(){
        tvResultado.text="Perdeu"
        tvResultado.setTextColor(ContextCompat.getColor(this,R.color.derrota))
    }

    private fun empatou(){
        tvResultado.text="Empatou"
        tvResultado.setTextColor(ContextCompat.getColor(this,R.color.empate))
    }
}
