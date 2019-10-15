package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.ContentDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter

class ContentDetailsConverter : PropertyConverter<ContentDetails, String> {

    override fun convertToDatabaseValue(entityProperty: ContentDetails?): String? {
        return if (entityProperty == null) {
            null
        } else Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): ContentDetails? {
        return if (databaseValue == null) {
            null
        } else Gson().fromJson(databaseValue, object : TypeToken<ContentDetails>() {

        }.type)
    }


}