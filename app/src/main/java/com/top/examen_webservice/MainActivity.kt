package com.top.examen_webservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alumnes = findViewById<Button>(R.id.buttonAlumnes)
        val cicles = findViewById<Button>(R.id.buttonCicles)

        val aprovats = findViewById<Button>(R.id.buttonAlumnesAprov)
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

        alumnes.setOnClickListener {
            val intent = Intent(this, AlumnesActivity::class.java)
            startActivity(intent)
        }
        cicles.setOnClickListener {
            val intent2 = Intent(this, CiclesActivity::class.java)
            startActivity(intent2)
        }
    }
}