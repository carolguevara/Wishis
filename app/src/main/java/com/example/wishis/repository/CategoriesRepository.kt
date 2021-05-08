package com.example.wishis.repository

import com.example.wishis.utils.DataState
import com.example.wishis.room.CatDao
import com.example.wishis.retrofit.CatRetrofit
import com.example.wishis.room.CacheMapper
import com.example.wishis.retrofit.CategoriesMapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoriesRepository constructor(

    private val catDao: CatDao,
    private val catRetrofit: CatRetrofit,
    private val cacheMapper: CacheMapper,
    private val categoriesMapper: CategoriesMapper
) {
        suspend fun getCategories(): Flow<DataState> = flow {
            emit(DataState.Loading)
            delay(5000)
            try {
                val catData = catRetrofit.get_categories()
                val catMap = categoriesMapper.mapFromEntityList(catData)
                for (tempCat in catMap){
                    catDao.insert(cacheMapper.mapToEntity(tempCat))
                }
                val cacheCat = catDao.get()
                emit(DataState.Success(cacheMapper.mapFromEntityList(cacheCat)))
            }catch (e: Exception){
                emit(DataState.Error(e))
            }
        }
    }
}