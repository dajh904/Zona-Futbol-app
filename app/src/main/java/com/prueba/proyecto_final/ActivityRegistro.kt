package com.prueba.proyecto_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityRegistro : AppCompatActivity() {

    lateinit var btn_registrar : Button
    lateinit var btn_back : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_registro)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_registrar = findViewById(R.id.btn_registrar)
        btn_registrar.setOnClickListener {
            val ingresar = Intent(this, MainActivity::class.java)
            startActivity(ingresar)
        }

        btn_back = findViewById(R.id.iv_back)
        btn_back.setOnClickListener {
            val ingresar = Intent(this, MainActivity::class.java)
            startActivity(ingresar)
        }
    }
}