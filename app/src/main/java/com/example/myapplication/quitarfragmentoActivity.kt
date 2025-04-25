package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class quitarfragmentoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quitar_fragmento) // Usa tu layout

        val input = findViewById<EditText>(R.id.inputTexto)
        val button = findViewById<Button>(R.id.btnSolucionar)
        val resultado = findViewById<TextView>(R.id.tvResultado)

        button.setOnClickListener {
            val texto = input.text.toString()
            resultado.text = quitarFragmento(texto)
        }
    }

    private fun quitarFragmento(texto: String): String {
        val primeraH = texto.indexOf('h')
        val ultimaH = texto.lastIndexOf('h')

        // Si hay menos de 2 'h', regresa mensaje de error o el mismo texto
        if (primeraH == -1 || ultimaH == -1 || primeraH == ultimaH) {
            return "La cadena debe contener al menos dos letras 'h'"
        }

        // Concatenamos la parte antes de la primera 'h' y después de la última 'h'
        val antes = texto.substring(0, primeraH)
        val despues = texto.substring(ultimaH + 1)
        return antes + despues
    }
}