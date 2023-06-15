package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edtMsg)
        val edtAltura: EditText = findViewById(R.id.editAltura)
        val tvResultado: TextView = findViewById(R.id.txtmsg)
        //val name: EditText = findViewById(R.id.edtNome)

        btnCalcular.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }   else {
                Toast.makeText(this, "preencher todos os campos", Toast.LENGTH_LONG).show()
            }
            }
        }

    }

        /*
        TABELA IMC
        Menor que 18,5      Abaixo do peso
        Entre 18,5 e 24,9   Normal 0
        Entre 25,0 e 29,9   Sobrepeso I
        Entre 30,0 e 39,9   Obesidade II
        Maior que 40,0      Obesidade Grave III
         */






