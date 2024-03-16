package com.example.composepritices.repository

import com.android.identity.util.Logger.d
import com.example.composepritices.db.Dao
import com.example.composepritices.db.toModel
import com.example.composepritices.model.network.API
import com.example.composepritices.model.vo.ProductItemState
import com.example.composepritices.model.vo.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val api: API,
    private val dao:Dao
    ) : NetworkRepositoryService{
    private val emitResult= ProductItemState().copy(loading = false)
    override suspend fun getAllService(): Flow<ProductItemState> = flow {
        val isEmpty= withContext(Dispatchers.IO){
            dao.selectAllProduct()?.isEmpty()==true
        }
        try{
            if(isEmpty){
                dao.insertAll(api.getAllService().toEntity())
                emit(emitResult)
                val getFromDataBase=dao.selectAllProduct().toModel()
                emit(ProductItemState().copy(result = getFromDataBase, loading = true))
            } else{
                emit(emitResult)
                val getFromDataBase= withContext(Dispatchers.IO){
                    dao.selectAllProduct().toModel()
                }
                emit(ProductItemState().copy(result = getFromDataBase, loading = true))
            }
        }catch (e:Exception){
          val error= ProductItemState().copy(error = e.localizedMessage, loading = false)
            emit(error)
        }
    }
}