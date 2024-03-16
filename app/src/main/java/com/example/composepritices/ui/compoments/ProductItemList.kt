package com.example.composepritices.ui.compoments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepritices.R
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.ui.theme.ComposePriticesTheme

@Composable
fun ProductItemList(
    modifier:Modifier=Modifier,
    goToDetail:(item:ProductItemDataVO) -> Unit,
    productItem:List<ProductItemDataVO> = listOf()
){
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(productItem,key={item -> item.id  }){productItem->
            ProductItem(
                modifier=modifier,
                productItem,
                onCLick = {
                    goToDetail(it)
                }
            )
        }
    }
}



