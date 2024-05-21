package com.example.composepritices.articlegrid

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composepritices.R
import com.example.composepritices.model.viwemodel.ArticleViewModel
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.model.vo.ProductItemState
import com.example.composepritices.ui.compoments.ProductGrid
import com.example.composepritices.ui.compoments.ProductGridList
import com.example.composepritices.ui.compoments.baseStatus
import com.example.composepritices.ui.theme.ComposePriticesTheme
import dagger.hilt.EntryPoint

@Composable
fun ArticleGridScreen(
    modifier: Modifier=Modifier,
    productItemState: ProductItemState?,
    goToDetail:(item:ProductItemDataVO)-> Unit={}
    ){
    Surface {
        Column (modifier = modifier
            .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                modifier =
                Modifier
                    .paddingFromBaseline(top = 16.dp, bottom = 16.dp)
                    .padding(start = 8.dp),
                text = stringResource(id = R.string.ArticleGrid),
                style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.primary)
            )
            if(productItemState?.loading==true){
                if(productItemState.result?.isNotEmpty()==true){
                    ProductGridList(
                        modifier = Modifier,
                        productItemList=productItemState.result,
                        gotoProductDetail=goToDetail)
                }else{
                    baseStatus()
                }
            }else{
                Box (modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
        }
    }
}
