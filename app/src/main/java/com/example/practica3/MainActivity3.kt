package com.example.practica3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        init()
    }
    private fun init(){

        val language = findViewById<ImageView>(R.id.language)
        if (Locale.getDefault().language == "en")
            language.setImageResource(R.mipmap.usa_foreground)
        else if (Locale.getDefault().language == "es")
            language.setImageResource(R.mipmap.spain_foreground)
    }
}