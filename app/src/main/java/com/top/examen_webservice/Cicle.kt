package com.top.examen_webservice

import com.google.gson.annotations.SerializedName

data class Cicle(
    @SerializedName("id")
    val id: String?,
    @SerializedName("nom")
    val nom:String,
    @SerializedName("nivell")
    val nivell:String,

    )