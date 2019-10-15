package com.embibe.app.embibetvapp.model

import com.embibe.app.embibetvapp.model.convertor.ContentDataConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class MyList {
    @Id(assignable = true)
    var id: Long = 0
    @Convert(converter = ContentDataConverter::class, dbType = String::class)
    var content: Item? = null
}