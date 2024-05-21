package com.example.composepritices.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composepritices.model.vo.ProductItemDataVO

@Entity
data class ProductEntities(
    @PrimaryKey val id:Int,
    val image:String,
    val name:String
)

fun List<ProductEntities>.toModel():List<ProductItemDataVO>{
    return map {
        ProductItemDataVO(
            id = it.id,
            name = it.name,
            image = it.image,
            loading = true
        )
    }
}
