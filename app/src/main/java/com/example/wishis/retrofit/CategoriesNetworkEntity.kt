package com.example.wishis.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.example.wishis.model.Image

data class CategoriesNetworkEntity (

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("categoria")
    @Expose
    var categoria: String,


    )