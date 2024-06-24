package com.claudiocastillo.apipractica.model

import com.google.gson.annotations.SerializedName

data class DogResponse (
    @SerializedName("message") val imageUrl: String,
    @SerializedName("status") val status: String
)