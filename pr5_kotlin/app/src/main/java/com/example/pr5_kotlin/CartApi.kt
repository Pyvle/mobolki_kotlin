package com.example.pr5_kotlin

import retrofit2.http.GET
import retrofit2.http.Query

interface CartApi {
    @GET("carts")
    suspend fun getCarts(
        @Query("limit") limit: Int,
    ): CartResponse
}