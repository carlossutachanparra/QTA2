package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DosMitadesActivity : AppCompatActivity() {

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

        // ------ BOTTOM NAVIGATION ------
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dos_mitades -> {
                    // Ya estamos en esta activity
                    true
                }
                R.id.dos_palabras -> {
                    startActivity(Intent(this, DosPalabrasActivity::class.java))
                    finish()
                    true
                }
                R.id.quitar_fragmento -> {
                    startActivity(Intent(this, quitarfragmentoActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
        // Esto marca el ítem actual como seleccionado en la barra
        bottomNav.selectedItemId = R.id.dos_mitades

        val closeButton = findViewById<ImageView>(R.id.closeButton)

        closeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra esta actividad actual para que no quede en el stack
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