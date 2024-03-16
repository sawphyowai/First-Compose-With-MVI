package com.example.composepritices.ui.compoments

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.ui.theme.ComposePriticesTheme

@Composable
fun ProductItem(modifier:Modifier=Modifier,
                item:ProductItemDataVO,
                onCLick:(item:ProductItemDataVO) -> Unit={}
                ){
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
      Row(
          modifier = modifier
              .fillMaxWidth()
              .heightIn(120.dp)
              .padding(horizontal = 10.dp)
              .clickable { onCLick(item) }
          ,
          verticalAlignment = Alignment.CenterVertically,
      ){
          baseImage(item = item, modifier =modifier )

          Spacer(modifier = modifier.width(10.dp))

          Text(text = item.name,
              style = MaterialTheme.typography.titleMedium,
              maxLines = 1
              )
      }
    }
}
