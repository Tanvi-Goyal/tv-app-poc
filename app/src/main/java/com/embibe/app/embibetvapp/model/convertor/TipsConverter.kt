package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Tips
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter

class TipsConverter : PropertyConverter<List<Tips>, String> {

    override fun convertToDatabaseValue(entityProperty: List<Tips>?): String? {
        return if (entityProperty == null) {
            null
        } else Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): List<Tips>? {
        return if (databaseValue == null) {
            return null
        } else Gson().fromJson(databaseValue, object : TypeToken<List<Tips>>() {
        }.type)
    }


}