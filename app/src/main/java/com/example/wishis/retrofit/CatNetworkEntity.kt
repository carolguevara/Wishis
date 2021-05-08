package com.example.wishis.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatNetworkEntity {

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("categoria")
    @Expose
    var categoria: String,

    @SerializedName("url")
    @Expose
    var url: String,

}