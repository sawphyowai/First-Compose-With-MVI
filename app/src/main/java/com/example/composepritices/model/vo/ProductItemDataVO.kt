package com.example.composepritices.model.vo

import android.net.Uri
import com.example.composepritices.db.ProductEntities
import com.google.gson.Gson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi

@JsonClass(generateAdapter = true)
data class ProductItemDataVO(
    @Json(name = "id")
    val id:Int,
    @Json(name = "url")
    val image:String,
    @Json(name = "title")
    val name:String,
    var error:String="",
    var loading:Boolean=false
){
    override fun toString(): String = Uri.encode(Gson().toJson(this))
}

fun List<ProductItemDataVO>.toEntity():List<ProductEntities>{
   return map {
       ProductEntities(
           id=it.id,
           image = it.image,
           name = it.name
       )
   }
}