package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Anotation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter
import org.json.JSONArray

class AnnotationDetailsConverter : PropertyConverter<List<Anotation>, String> {


    override fun convertToDatabaseValue(entityProperty: List<Anotation>?): String? {
        return if (entityProperty == null) {
            null
        } else {
            val jsArray = Gson().toJson(JSONArray(entityProperty))
            Gson().toJson(jsArray)
        }
    }

    override fun convertToEntityProperty(databaseValue: String?): List<Anotation>? {
        return if (databaseValue == null) {
            return null
        } else Gson().fromJson(databaseValue, object : TypeToken<List<Anotation>>() {

        }.type)
    }


}