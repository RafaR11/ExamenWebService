package com.top.examen_webservice

import org.intellij.lang.annotations.Identifier
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Body
import java.util.*
import kotlin.collections.HashMap


interface ApiService {
    @Headers("Content-type: application/json")
    @GET("alumnes")
    fun allAlumnes(): Call<MutableList<Alumne>>


    @DELETE("alumnes/{id}")
    fun deleteByID(@Path("id") id: String):Call<Alumne>

    @GET("cicles")
    fun allCicles(): Call<MutableList<Cicle>>
    @GET("cicles")
    fun findCicle(@Query("id") id: String):Call<MutableList<Cicle>>

    @FormUrlEncoded
    @PUT("alumnes/{id}")
    fun updateData(@Path("id") id: String, @Field(value = "nom") nom: String): Call<Alumne>



}