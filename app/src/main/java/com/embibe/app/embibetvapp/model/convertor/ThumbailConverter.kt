package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Thumbnails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter

class ThumbailConverter : PropertyConverter<Thumbnails, String> {

    override fun convertToDatabaseValue(entityProperty: Thumbnails?): String? {
        return if (entityProperty == null) {
            null
        } else Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): Thumbnails? {
        return if (databaseValue == null) {
            null
        } else Gson().fromJson(databaseValue, object : TypeToken<Thumbnails>() {

        }.type)
    }


}