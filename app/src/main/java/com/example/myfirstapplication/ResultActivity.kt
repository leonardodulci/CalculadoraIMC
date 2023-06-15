package com.example.myfirstapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult: TextView = findViewById(R.id.textview_result)
        val tvClassificacao: TextView = findViewById(R.id.textview_classificacao)

        val result: Float = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        //val nome: String? = intent.getStringExtra("EXTRA_NAME")

        tvResult.text = result.toString()


        var classificacao = if(result < 18.5f){
            "Abaixo do peso!!"
        } else if(result in 18.5f..24.9f){
            "Peso Normal"
        }   else if(result >= 25.0f && result < 29.9f){
            "Sobrepeso I"
        }      else if(result >= 30.0f && result < 39.9){
            "Obesidade II"
        }          else{
            "Obesidade Grave III"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}