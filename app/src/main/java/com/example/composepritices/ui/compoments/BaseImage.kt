package com.example.composepritices.ui.compoments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.composepritices.model.vo.ProductItemDataVO

@Composable
fun baseImage(item:ProductItemDataVO,modifier: Modifier){
    Image(
        contentScale = ContentScale.Crop,
        modifier=modifier.size(80.dp).clip(CircleShape),
        painter = rememberAsyncImagePainter(item.image),
        contentDescription = null,
    )
}