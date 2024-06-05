package com.prueba.proyecto_final

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class PerfilActivity : AppCompatActivity(){
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_perfil)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_guardar : Button = findViewById(R.id.btn_guardar)
        val btn_cancelar : TextView = findViewById(R.id.tv_cancelar)
        val reserva = Intent(this, HomeActivity::class.java)

        btn_guardar.setOnClickListener { startActivity(reserva)}
        btn_cancelar.setOnClickListener { startActivity(reserva) }

        //Menú desplegable

        val drawerLayout : DrawerLayout = findViewById(R.id.activity_perfil)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val historial = Intent(this, HistorialActivity::class.java)
        val perfil = Intent(this, PerfilActivity::class.java)
        val logout = Intent(this, MainActivity::class.java)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_reservar -> startActivity(reserva)
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