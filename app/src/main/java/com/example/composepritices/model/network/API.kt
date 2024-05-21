package com.example.composepritices.model.network

import com.example.composepritices.model.vo.ProductItemDataVO
import retrofit2.http.GET

interface API {
    @GET("photos")
    suspend fun getAllService():List<ProductItemDataVO>
}