package com.top.examen_webservice

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

class CiclesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cicles)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerCicles)
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

        val id = findViewById<EditText>(R.id.editTextIdCicle)
        val buscar = findViewById<Button>(R.id.buttonTotsCicles)
        val filtrar = findViewById<Button>(R.id.buttonFiltrarCicle)

        filtrar.setOnClickListener {
            var textnom = id.text.toString()
            var call1 = serviceGenerator.findCicle(textnom)
            call1.clone().enqueue(object : Callback<MutableList<Cicle>> {
                override fun onResponse(call1: Call<MutableList<Cicle>>, response: Response<MutableList<Cicle>>){
                    if (response.isSuccessful){
                        recyclerview.apply {
                            layoutManager = LinearLayoutManager(this@CiclesActivity)
                            adapter = AdapterCicles(response.body()!!)
                            Toast.makeText(applicationContext,"cicle filtrat!",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                override fun onFailure(call: Call<MutableList<Cicle>>, t: Throwable){
                    t.printStackTrace()
                    Log.e("error", t.message.toString())
                }

            })
        }

        buscar.setOnClickListener {
            val all = serviceGenerator.allCicles()
            all.clone().enqueue(object : Callback<MutableList<Cicle>> {
                override fun onResponse(call: Call<MutableList<Cicle>>, response: Response<MutableList<Cicle>>){
                    if (response.isSuccessful){
                        recyclerview.apply {
                            layoutManager = LinearLayoutManager(this@CiclesActivity)
                            adapter = AdapterCicles(response.body()!!)
                            Toast.makeText(applicationContext,"GET correcte!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                override fun onFailure(call: Call<MutableList<Cicle>>, t: Throwable){
                    t.printStackTrace()
                    Log.e("error", t.message.toString())
                }

            })
        }
    }
}