package com.example.wishis.retrofit

import com.example.wishis.model.Cat
import com.example.wishis.utils.EntityMapper

import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<CatNetworkEntity, Cat> {
    override fun mapFromEntity(entity: CatNetworkEntity): Cat {
        return Cat(
            id = entity.id,
            categoria = entity.categoria,
            url= entity.url

        )
    }

    override fun mapToEntity(domainModel: Cat): CatNetworkEntity {
        return CatNetworkEntity(
            id = domainModel.id,
            categoria = domainModel.categoria,
            url= domainModel.url
        )
    }

    fun mapFromEntityList(entities: List<CatNetworkEntity>): List<Cat>{
        return entities.map { mapFromEntity(it) }
    }
}