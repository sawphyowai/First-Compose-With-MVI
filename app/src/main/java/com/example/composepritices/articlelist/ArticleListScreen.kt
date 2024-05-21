package com.example.composepritices.articlelist

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android.identity.util.Logger.d
import com.example.composepritices.MainActivity
import com.example.composepritices.R
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.model.vo.ProductItemState
import com.example.composepritices.ui.compoments.ProductItemList
import com.example.composepritices.ui.compoments.baseStatus

@Composable
fun ArticleListScreen(
    modifier: Modifier=Modifier,
    productItemState: ProductItemState?,
    goToDetail:(item:ProductItemDataVO) -> Unit
    ){
    Surface {
        Column (modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxSize(),
        ){
            Text(
                modifier =
                Modifier
                    .paddingFromBaseline(top = 16.dp, bottom = 16.dp)
                    .padding(start = 8.dp),
                text = stringResource(id = R.string.ArticleList),
                style =MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.primary)
            )
            if(productItemState?.loading==true){
                if(productItemState?.result?.isNotEmpty()==true){
                    ProductItemList(goToDetail = goToDetail, productItem = productItemState.result ?: listOf())
                }else{
                    baseStatus()
                }
            }else{
                if(productItemState?.error?.isNotEmpty()==true){
                    Toast.makeText(
                        LocalContext.current,
                        productItemState.error,
                        Toast.LENGTH_LONG
                        ).show()
                }else{
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(modifier=Modifier)

                    }
                }

            }
        }
    }
}

