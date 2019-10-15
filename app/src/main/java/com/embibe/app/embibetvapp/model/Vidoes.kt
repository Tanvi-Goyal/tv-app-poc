package com.embibe.app.embibetvapp.model

import com.embibe.app.embibetvapp.model.convertor.ContentListConverter
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
class Videos {
    @Id
    var id: Long = 0
    @SerializedName("title")
    var title: String = ""
    @SerializedName("type")
    val type: String = ""
    @SerializedName("items")
    @Convert(converter = ContentListConverter::class, dbType = String::class)
    var contentList: ArrayList<Item>? = null
    @Backlink(to = "video")
    lateinit var contents: ToMany<Item>

    // Used to determine whether the row shall use shadows when displaying its cards or not.
    @SerializedName("shadow")
    val mShadow = true
}
