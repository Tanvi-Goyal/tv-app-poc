package com.embibe.app.embibetvapp.model

import com.embibe.app.embibetvapp.model.convertor.QuestionDataConverter
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne

@Entity
class Anotation {
    @Id
    var id: Long = 0

    @SerializedName("annotation_point")
    val point: Long = 0

    @SerializedName("questions")
    @Convert(converter = QuestionDataConverter::class, dbType = String::class)
    var questions: ArrayList<Question>? = null


    lateinit var content: ToOne<Item>

    @Backlink
    lateinit var questionList: ToMany<Question>


}
