package com.example.practica3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    fun init(){
        val btn1 = findViewById<ImageButton>(R.id.btn1)
        val btn2 = findViewById<ImageButton>(R.id.btn2)
        val btn3 = findViewById<ImageButton>(R.id.btn3)
        val btn4 = findViewById<ImageButton>(R.id.btn4)
        val btn5 = findViewById<ImageButton>(R.id.btn5)
        val btn6 = findViewById<ImageButton>(R.id.btn6)
        val language = findViewById<ImageView>(R.id.language)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        if(Locale.getDefault().getLanguage() == "en")
            language.setImageResource(R.mipmap.usa_foreground)
        else if(Locale.getDefault().getLanguage() == "es")
            language.setImageResource(R.mipmap.spain_foreground)
    }

    override fun onClick(v:View){
        if(R.id.btn1!=v.id){
            Toast.makeText(this,getString(R.string.opcion_todavia_no_configurada),Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}