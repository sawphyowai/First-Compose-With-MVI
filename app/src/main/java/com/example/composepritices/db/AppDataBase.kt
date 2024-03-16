package com.example.composepritices.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntities::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun productDao():Dao
}