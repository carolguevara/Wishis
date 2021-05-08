package com.example.wishis.room
import com.example.wishis.utils.EntityMapper
import  com.example.wishis.model.Cat
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<CatCacheEntity, Cat> {
    override fun mapFromEntity(entity: CatCacheEntity): Cat {
        return Cat(
            id = entity.id,
            url = entity.url,
            categoria = entity.categoria
        )
    }

    override fun mapToEntity(domainModel: Cat): CatCacheEntity {
        return CatCacheEntity(
            id = domainModel.id,
            url = domainModel.url,
            categoria = domainModel.categoria

        )
    }

    fun mapFromEntityList(entities: List<CatCacheEntity>): List<Cat>{
        return entities.map { mapFromEntity(it) }
    }
}