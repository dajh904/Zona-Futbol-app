package com.prueba.proyecto_final

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Funciones principales de la vista
        val btn_res1 : Button = findViewById(R.id.btn_reserva1)
        val btn_res2 : Button = findViewById(R.id.btn_reserva2)
        val btn_res3 : Button = findViewById(R.id.btn_reserva3)
        val reserva = Intent(this, ReservaActivity::class.java)

        btn_res1.setOnClickListener { startActivity(reserva) }
        btn_res2.setOnClickListener { startActivity(reserva) }
        btn_res3.setOnClickListener { startActivity(reserva) }

        //Menú desplegable
        val drawerLayout: DrawerLayout = findViewById(R.id.activity_home)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val home = Intent(this, HomeActivity::class.java)
        val historial = Intent(this, HistorialActivity::class.java)
        val perfil = Intent(this, PerfilActivity::class.java)
        val logout = Intent(this, MainActivity::class.java)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_reservar -> startActivity(home)
                R.id.nav_historial -> startActivity(historial)
                R.id.nav_perfil -> startActivity(perfil)
                R.id.nav_logout -> startActivity(logout)
            }

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}