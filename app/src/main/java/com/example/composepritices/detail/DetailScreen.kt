package com.example.composepritices.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.composepritices.R
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.ui.compoments.baseImage
import com.example.composepritices.ui.theme.ComposePriticesTheme

@Composable
fun DetailScreen(item: ProductItemDataVO){
    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            )
        {
            Spacer(modifier = Modifier.height(10.dp))

            baseImage(item = item, modifier =Modifier.size(200.dp) )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                item.name,
                style = MaterialTheme.typography.
            bodyMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                    textAlign= TextAlign.Center
                )
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    ComposePriticesTheme {
//        DetailScreen()
    }
}