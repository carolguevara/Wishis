package com.example.wishis.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.wishis.model.Image

@Entity(tableName =  "Categories")
class CategoriesCacheEntity (


    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "url")
    var url: String,

    var image: Image,



    ) {

}
