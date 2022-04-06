package com.top.examen_webservice

import com.google.gson.annotations.SerializedName

data class Alumne(
    @SerializedName("id")
    var id: String?,
    @SerializedName("nom")
    var nom:String,

    )