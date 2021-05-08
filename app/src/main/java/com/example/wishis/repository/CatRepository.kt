package com.example.wishis.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.wishis.retrofit.CatRetrofit
import com.example.wishis.room.CacheMapper
import com.example.wishis.retrofit.CategoriesMapper
import com.example.wishis.room.CatDao
import com.example.wishis.utils.DataState
import com.example.wishis.retrofit.NetworkMapper
import retrofit2.HttpException

class CatRepository constructor(
    private val catDao: CatDao,
    private val catRetrofit: CatRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getCats(): Flow<DataState> = flow {
        emit(DataState.Error(java.lang.Exception("error custom")))
        delay(5000)
        try {
            val catData = catRetrofit.get()
            404, 400-499, 500-599
            val catMap = networkMapper.mapFromEntityList(catData)
            for (tempCat in catMap){
                catDao.insert(cacheMapper.mapToEntity(tempCat))
            }
            val cacheCat = catDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheCat)))
        }catch (e: HttpException){
            val cacheCat = catDao.get()
            //EMIT: Es un notificador de que una accion se ha completado o ha dado un error.
            // El medio de transporte es DataState.
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheCat)))
        }
    }
}