package com.example.wishis.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image (


    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("categoria")
    @Expose
    var categoria: String,
)