package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Snippet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter

class SnippetConverter : PropertyConverter<Snippet, String> {

    override fun convertToDatabaseValue(entityProperty: Snippet?): String? {
        return if (entityProperty == null) {
            null
        } else Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): Snippet? {
        return if (databaseValue == null) {
            null
        } else Gson().fromJson(databaseValue, object : TypeToken<Snippet>() {

        }.type)
    }


}