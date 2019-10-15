package com.embibe.app.embibetvapp.model

import com.embibe.app.embibetvapp.model.convertor.MediumConverter
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Thumbnails {
    @Id
    var id: Long = 0
    @SerializedName("medium")
    @Convert(converter = MediumConverter::class, dbType = String::class)
    val medium: Medium? = null
}