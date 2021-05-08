package com.example.wishis.retrofit

import retrofit2.http.GET

interface CategoriesRetrofit {
    @GET("search")
    suspend fun get(): List<CategoriesNetworkEntity>
}