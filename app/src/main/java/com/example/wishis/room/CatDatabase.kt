package com.example.wishis.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CatCacheEntity::class, CategoriesCacheEntity::class], version = 1)
abstract class CatDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "wishiDB"
    }
    abstract fun catDao(): CatDao
    /* Notifica a ROOM que existe una clase llamada CategoriesDao en la cual se va a manejar
    * toda la logica (CRUD) de la tabla [Categories]
    */
    abstract fun categoriesDao(): CategoriesDao

}