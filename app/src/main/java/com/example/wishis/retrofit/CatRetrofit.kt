package com.example.wishis.retrofit

import retrofit2.http.GET

interface CatRetrofit {

    @GET("search")
    suspend fun get(): List<CatNetworkEntity>

    @GET("categories")
    suspend fun get_categories(): List<CategoriesNetworkEntity>

}