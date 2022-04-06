package com.top.examen_webservice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlumnesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnes)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerAlumnes)
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

        val nom = findViewById<EditText>(R.id.editTextNameAlumne)
        val id = findViewById<EditText>(R.id.editTextIdAlumne)
        val buscar = findViewById<Button>(R.id.buttonTotsAlumnes)
        val eliminar = findViewById<Button>(R.id.buttonBorrarAlumnes)
        val modificar = findViewById<Button>(R.id.buttonModifAlumne)

        eliminar.setOnClickListener {
            var textnom = id.text
            var call2 = serviceGenerator.deleteByID(textnom.toString())
            call2.clone().enqueue(object : Callback<Alumne> {
                override fun onResponse(call1: Call<Alumne>, response: Response<Alumne>) {
                    if (response.isSuccessful) {
                        Toast.makeText(applicationContext, "Alumne eliminat!", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Alumne>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("error", t.message.toString())
                }

            })
        }

        buscar.setOnClickListener {
            val all = serviceGenerator.allAlumnes()
            all.clone().enqueue(object : Callback<MutableList<Alumne>> {
                override fun onResponse(
                    call: Call<MutableList<Alumne>>,
                    response: Response<MutableList<Alumne>>
                ) {
                    if (response.isSuccessful) {
                        recyclerview.apply {
                            layoutManager = LinearLayoutManager(this@AlumnesActivity)
                            adapter = AdapterAlumnes(response.body()!!)
                            Toast.makeText(applicationContext, "GET correcte!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }

                override fun onFailure(call: Call<MutableList<Alumne>>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("error", t.message.toString())
                }

            })
        }

        modificar.setOnClickListener {
            if (id.text.isEmpty() || nom.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Has d'introduïr una ID i el nom que li vols assignar!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val update = serviceGenerator.updateData(id.text.toString(), nom.text.toString())
                update.enqueue(object : Callback<Alumne> {
                    override fun onResponse(call: Call<Alumne>, response: Response<Alumne>) {
                        if (response.isSuccessful) {
                            Toast.makeText(applicationContext, "Alumne modificat!", Toast.LENGTH_SHORT)
                                .show()
                            var updated = response.body()
                        } else {
                            Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Alumne>, t: Throwable) {
                    }

                })
            }
        }
    }


}