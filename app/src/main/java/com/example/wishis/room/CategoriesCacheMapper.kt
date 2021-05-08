package com.example.wishis.room

import com.example.wishis.model.Category
import com.example.wishis.model.Cat
import com.example.wishis.model.Categories
import com.example.wishis.retrofit.CategoriesNetworkEntity
import com.example.wishis.utils.EntityMapper

import javax.inject.Inject

class CategoriesCacheMapper
@Inject
constructor():
    EntityMapper<CategoriesCacheEntity, Categories> {
    override fun mapFromEntity(entity: CategoriesCacheEntity): Categories {
        return Categories(

            id = entity.id,
            name= entity.name,
            url= entity.url,
            image = entity.image


        )
    }

    override fun mapToEntity(domainModel: Categories): CategoriesCacheEntity {
        return CategoriesCacheEntity(

            id = domainModel.id,
            name = domainModel.name,
            url = domainModel.url,
            image = domainModel.image

        )

    }

    fun mapFromEntityList(entities: List<CategoriesCacheEntity>): List<Categories>{
    return entities.map { mapFromEntity(it) }
}
    }