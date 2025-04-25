package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class dosmitadesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_mitades) // Usa el nombre exacto de tu layout

        val editText = findViewById<EditText>(R.id.inputTexto)
        val button = findViewById<Button>(R.id.btnSolucionar)
        val resultado = findViewById<TextView>(R.id.tvResultado)

        button.setOnClickListener {
            val textoIngresado = editText.text.toString()
            if (textoIngresado.isNotEmpty()) {
                resultado.text = intercambiarMitades(textoIngresado)
            } else {
                resultado.text = "Por favor ingrese una cadena de texto"
            }
        }
    }

    // Función que intercambia las mitades siguiendo el enunciado
    private fun intercambiarMitades(cadena: String): String {
        val mitad = (cadena.length + 1) / 2
        val primera = cadena.substring(0, mitad)
        val segunda = cadena.substring(mitad)
        return segunda + primera
    }
}