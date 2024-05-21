package com.example.composepritices.model.viwemodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.identity.util.Logger.d
import com.example.composepritices.intent.Intent
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.model.vo.ProductItemState
import com.example.composepritices.repository.NetworkRepositoryService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repositoryService: NetworkRepositoryService) :ViewModel() {
    private var _articleService = MutableStateFlow<ProductItemState>(
        ProductItemState(loading = false)
    )
    val articleService: StateFlow<ProductItemState> = _articleService.asStateFlow()

    private var articleList:List<ProductItemDataVO> = listOf()

    init {
        getAllService(Intent.LoadingIntent)
    }

    fun getAllService(intent: Intent) {
        reduce(ProductItemState(result = articleList),intent)
    }

    private fun reduce(state:ProductItemState,intent: Intent){
        when(intent){
            Intent.LoadingIntent ->{
                viewModelScope.launch(Dispatchers.Main) {
                    repositoryService.getAllService().collect { productItemState ->
                        productItemState.apply {
                            d("OKOK_Productitem",this.error.toString())
                            articleList=result
                            _articleService.value=this
                        }
                    }
                }
            }
            is Intent.FilterIntent->{
                _articleService.value=state.copy(
                    loading = true,
                    result = if(intent.name.isEmpty()){
                        state.result
                    }else{
                        state.result.filter { it.name.contains(intent.name) }
                    }
                )
            }

        }
    }

}



