package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Answer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter

class AnswerConverter : PropertyConverter<List<Answer>, String> {

    override fun convertToDatabaseValue(entityProperty: List<Answer>?): String? {
        return if (entityProperty == null) {
            null
        } else Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): List<Answer>? {
        return if (databaseValue == null) {
            return null
        } else Gson().fromJson(databaseValue, object : TypeToken<List<Answer>>() {
        }.type)
    }


}