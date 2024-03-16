package com.example.composepritices.model.vo

data class ProductItemState(
    var loading:Boolean=false,
    var result:List<ProductItemDataVO> = listOf(),
    var error:String=""
)
