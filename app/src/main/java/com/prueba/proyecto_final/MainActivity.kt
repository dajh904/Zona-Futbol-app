package com.prueba.proyecto_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btn_ingresar :Button
    lateinit var btn_registro :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_ingresar = findViewById(R.id.bt_ingresar)
        btn_registro = findViewById(R.id.tv_registrarme)

        btn_ingresar.setOnClickListener {
            val ingresar = Intent(this, HomeActivity::class.java)
            startActivity(ingresar)
        }

        btn_registro.setOnClickListener {
            val registro = Intent(this, ActivityRegistro::class.java)
            startActivity(registro)
        }

    }
}