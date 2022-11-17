package com.example.practica3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    val name = findViewById<EditText>(R.id.edtName)
    val email = findViewById<EditText>(R.id.edtEmail)
    val emailR = findViewById<EditText>(R.id.edtEmailRepeat)
    val mCuadrados = findViewById<EditText>(R.id.edtMetrosCuadrados)
    val observaciones = findViewById<EditText>(R.id.edtObservaciones)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
    }

    fun init() {
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        btnEnviar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (checkAllGood()) {

        }
    }

    fun checkAllGood(): Boolean {
        if (name.text.isNotEmpty() && email.text.isNotEmpty() && emailR.text.isNotEmpty() && mCuadrados.text.isNotEmpty()) {
            return true
        } else {
            if (name.text.isEmpty()) name.error = "la chupas"
            if (email.text.isEmpty()) email.error = "la chupas"
            if (emailR.text.isEmpty()) emailR.error = "la chupas"
            if (mCuadrados.text.isEmpty()) mCuadrados.error = "la chupas"
            return false
        }

    }
}