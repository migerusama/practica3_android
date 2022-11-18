package com.example.practica3

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity3 : AppCompatActivity() {
    private lateinit var tvNombre:TextView
    private lateinit var tvEmail:TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var name = intent.getStringExtra("nombre").toString()
        var email = intent.getStringExtra("email").toString()
        init()
        tvNombre.text = getString(R.string.gracias)+" "+name+getString(R.string.gracias2)
        tvEmail.text = getString(R.string.plazo)+" "+email
    }

    private fun init(){
        tvNombre = findViewById(R.id.tvNombre)
        tvEmail = findViewById(R.id.tvEmail)
        var btnBack = findViewById<Button>(R.id.btnVolver)
        btnBack.setOnClickListener { v -> startActivity(Intent(this,MainActivity::class.java))}
        val language = findViewById<ImageView>(R.id.language)
        if (Locale.getDefault().language == "en")
            language.setImageResource(R.mipmap.usa_foreground)
        else if (Locale.getDefault().language == "es")
            language.setImageResource(R.mipmap.spain_foreground)
    }
}