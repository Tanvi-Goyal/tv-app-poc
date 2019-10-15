package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Hint
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter

class HintsConverter : PropertyConverter<List<Hint>, String> {

    override fun convertToDatabaseValue(entityProperty: List<Hint>?): String? {
        return if (entityProperty == null) {
            null
        } else Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): List<Hint>? {
        return if (databaseValue == null) {
            return null
        } else Gson().fromJson(databaseValue, object : TypeToken<List<Hint>>() {
        }.type)
    }


}