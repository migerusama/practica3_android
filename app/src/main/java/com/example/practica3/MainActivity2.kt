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
                getString(R.string.rellene_correctamente_los_campos_obligatorios),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            showAlert()
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.desea_renviar_los_datos_al_servidor))
        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("nombre",name.text.toString())
            intent.putExtra("email",email.text.toString())
            startActivity(intent)
        }
        builder.setNegativeButton("NO") { dialog, which ->
            dialog.dismiss()
        }
        builder.setNeutralButton(getString(R.string.cancelar)) { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }

    private fun checkAllGood(): Boolean {
        return if (name.text.isNotEmpty() && email.text.isNotEmpty() && emailR.text.isNotEmpty() && mCuadrados.text.isNotEmpty() && email.text.toString().equals(emailR.text.toString())) {
            true
        } else {
            if (name.text.isEmpty()) name.error = getString(R.string.nombre_obligatorio)
            if (email.text.isEmpty()) email.error = getString(R.string.email_obligatorio)
            if (emailR.text.isEmpty()) {
                emailR.error = getString(R.string.repetir_email_obligatorio)
            }else if (!email.text.toString().equals(emailR.text.toString())){
                emailR.error = getString(R.string.ambos_email_tienen_que_ser_iguales)
            }
            if (mCuadrados.text.isEmpty()) mCuadrados.error = getString(R.string.m2_obligatorio)
            false
        }

    }
}