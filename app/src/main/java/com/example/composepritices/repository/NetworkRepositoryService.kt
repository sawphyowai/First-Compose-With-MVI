package com.example.composepritices.repository

import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.model.vo.ProductItemState
import kotlinx.coroutines.flow.Flow

interface NetworkRepositoryService {
   suspend fun getAllService(): Flow<ProductItemState>
}