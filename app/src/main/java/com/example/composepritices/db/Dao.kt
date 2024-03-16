package com.example.composepritices.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM ProductEntities")
    suspend fun selectAllProduct():List<ProductEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(insertAll:List<ProductEntities>)

}