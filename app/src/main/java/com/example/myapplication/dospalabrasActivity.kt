package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class dospalabrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_palabras) // ⬅ Cambia por el nombre de tu layout

        val inputTexto = findViewById<EditText>(R.id.inputTexto)
        val btnSolucionar = findViewById<Button>(R.id.btnSolucionar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnSolucionar.setOnClickListener {
            val texto = inputTexto.text.toString().trim()
            tvResultado.text = intercambiarDosPalabras(texto)
        }
    }

    private fun intercambiarDosPalabras(texto: String): String {
        // Quita espacios innecesarios y divide en palabras
        val palabras = texto.trim().split("\\s+".toRegex())
        return if (palabras.size == 2) {
            "${palabras[1]} ${palabras[0]}"
        } else {
            "Por favor ingresa exactamente dos palabras separadas por un espacio."
        }
    }
}