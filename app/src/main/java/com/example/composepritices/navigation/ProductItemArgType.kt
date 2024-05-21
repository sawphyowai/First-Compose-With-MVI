package com.example.composepritices.navigation

import com.example.composepritices.model.vo.ProductItemDataVO
import com.google.gson.Gson

class ProductItemArgType :JsonNavType<ProductItemDataVO>() {
    override fun fromJson(value: String): ProductItemDataVO {
        return Gson().fromJson(value,ProductItemDataVO::class.java)
    }

    override fun ProductItemDataVO.getJsonParse(): String {
        return Gson().toJson(this)
    }
}