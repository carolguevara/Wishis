package com.example.wishis.retrofit

import com.example.wishis.model.Categories
import com.example.wishis.utils.EntityMapper
import javax.inject.Inject

class CategoriesMapper
@Inject constructor(): EntityMapper <CategoriesNetworkEntity, Categories>{
    override fun mapFromEntity(entity: CategoriesNetworkEntity): Categories {
        return Categories(

           name = entity.name,
            id = entity.id,
            url = entity.url,


        )
    }

    override fun mapToEntity(domainModel: Categories): CategoriesNetworkEntity {
        return CategoriesNetworkEntity(

            name = domainModel.name,
            id = domainModel.id

        )
    }

    fun mapFromEntityList(entities: List<CategoriesNetworkEntity>): List<Categories>{
        return entities.map { mapFromEntity(it) }
    }
}