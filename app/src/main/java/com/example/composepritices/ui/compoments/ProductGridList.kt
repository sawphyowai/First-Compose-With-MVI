package com.example.composepritices.ui.compoments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.ui.theme.ComposePriticesTheme

@Composable
fun ProductGridList(
    modifier: Modifier,
    productItemList:List<ProductItemDataVO> = listOf(),
    gotoProductDetail:(item:ProductItemDataVO) -> Unit,
    ){
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
        items(
            productItemList,
            key={item-> item.id}
        ){productItems->
          ProductGrid(modifier = modifier,productItems,gotoProductDetail )
        }
    }
}

