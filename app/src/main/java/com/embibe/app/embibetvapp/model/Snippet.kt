package com.embibe.app.embibetvapp.model

import com.embibe.app.embibetvapp.model.convertor.ThumbailConverter
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

@Entity
class Snippet {
    @Id
    var id: Long = 0
    @SerializedName("thumb_image")
    val thumb_image: String = ""
    @SerializedName("url")
    val url: String = ""
    @SerializedName("publishedAt")
    val publishedAt: String = ""
    @SerializedName("lecturer")
    val lecturer: String = ""
    @SerializedName("creator")
    val creator: String = ""
    @SerializedName("match")
    val match: String = ""
    @SerializedName("title")
    val title: String = ""
    @SerializedName("description")
    val description: String = ""
    @SerializedName("thumbnails")
    @Convert(converter = ThumbailConverter::class, dbType = String::class)
    val thumbnails: Thumbnails? = null
    @SerializedName("channelTitle")
    val channelTitle: String = ""
    @SerializedName("categoryId")
    val categoryId: Int = 0

}
