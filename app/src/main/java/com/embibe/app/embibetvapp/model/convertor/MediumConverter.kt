package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Medium
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter

class MediumConverter : PropertyConverter<Medium, String> {

    override fun convertToDatabaseValue(entityProperty: Medium?): String? {
        return if (entityProperty == null) {
            null
        } else Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): Medium? {
        return if (databaseValue == null) {
            null
        } else Gson().fromJson(databaseValue, object : TypeToken<Medium>() {

        }.type)
    }


}