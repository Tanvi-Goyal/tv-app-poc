package com.embibe.app.embibetvapp.model

import com.embibe.app.embibetvapp.model.convertor.AnnotationDetailsConverter
import com.embibe.app.embibetvapp.model.convertor.ContentDetailsConverter
import com.embibe.app.embibetvapp.model.convertor.SnippetConverter
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne

@Entity
class Item {


    @Transient
    val type: Card.Type = Card.Type.DEFAULT
    @Transient
    var thumbnails: String = ""
    @SerializedName("id")
    var youtubeId: String = ""

    @Id
    var itemId: Long = 0

    @SerializedName("url")
    val url: String? = null

    @SerializedName("snippet")
    @Convert(converter = SnippetConverter::class, dbType = String::class)
    lateinit var snippet: Snippet

    @SerializedName("contentDetails")
    @Convert(converter = ContentDetailsConverter::class, dbType = String::class)
    var contentDetails: ContentDetails? = null

    @SerializedName("annotations")
    @Convert(converter = AnnotationDetailsConverter::class, dbType = String::class)
    var anotations: ArrayList<Anotation>? = null

    @Backlink
    lateinit var anotationList: ToMany<Anotation>


    lateinit var title :String
    lateinit var contentDescription :String

    //lateinit var snippetDetail: ToOne<Snippet>

    var downloaded: String = ""

    var anotationEnabled: Boolean = true

    var inMyList: Boolean = false

    lateinit var video: ToOne<Videos>


}
