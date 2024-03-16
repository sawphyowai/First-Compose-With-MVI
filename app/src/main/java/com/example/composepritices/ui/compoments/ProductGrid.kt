package com.example.composepritices.ui.compoments

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.ui.theme.ComposePriticesTheme

@Composable
fun ProductGrid(
    modifier:Modifier=Modifier,
    item:ProductItemDataVO,
    click:(item:ProductItemDataVO) -> Unit,
){
    Surface (
        modifier=modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant
    ){
        Column(
            modifier= modifier
                .padding(16.dp)
                .clickable { click(item) }
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            baseImage(item = item, modifier = modifier)
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary),
                maxLines = 1,
                textAlign= TextAlign.Center)

        }
    }
}

//@Preview
//@Composable
//fun ProductGridView(){
//    ComposePriticesTheme {
//        ProductGrid(
//            modifier =Modifier,
//            item = productList.first(),
//            click = {}
//        )
//    }
//}
