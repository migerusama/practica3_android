package com.example.practica3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var emailR: EditText
    private lateinit var mCuadrados: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
    }

    private fun init() {
        name = findViewById(R.id.edtName)
        email = findViewById(R.id.edtEmail)
        emailR = findViewById(R.id.edtEmailRepeat)
        mCuadrados = findViewById(R.id.edtMetrosCuadrados)
        btnEnviar = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener(this)
        val language = findViewById<ImageView>(R.id.language)
        if (Locale.getDefault().language == "en")
            language.setImageResource(R.mipmap.usa_foreground)
        else if (Locale.getDefault().language == "es")
            language.setImageResource(R.mipmap.spain_foreground)
    }

    override fun onClick(v: View) {
        if (!checkAllGood()) {
            Toast.makeText(
                this,
                "Rellene correctamente los campos obligatorios",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            showAlert()
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("¿Deséa enviar lso datos al servidor?")
        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("nombre",name.text.toString())
            intent.putExtra("email",email.text.toString())
            startActivity(intent)
        }
        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            dialog.dismiss()
        }
        builder.setNeutralButton("Cancelar") { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }

    private fun checkAllGood(): Boolean {
        return if (name.text.isNotEmpty() && email.text.isNotEmpty() && emailR.text.isNotEmpty() && mCuadrados.text.isNotEmpty()) {
            true
        } else {
            if (name.text.isEmpty()) name.error = "Nombre obligatorio"
            if (email.text.isEmpty()) email.error = "Email obligatorio"
            if (emailR.text.isEmpty()) {
                emailR.error = "Repetir email obligatorio"
                if (!email.text.equals(emailR.text))
                    emailR.error = "Ambos email tienen que ser iguales"
            }
            if (mCuadrados.text.isEmpty()) mCuadrados.error = "m² obligatorio"
            false
        }

    }
}