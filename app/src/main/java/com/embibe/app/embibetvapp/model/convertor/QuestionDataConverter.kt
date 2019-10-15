package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter
import org.json.JSONArray

class QuestionDataConverter : PropertyConverter<List<Question>, String> {


    override fun convertToDatabaseValue(entityProperty: List<Question>?): String? {
        return if (entityProperty == null) {
            null
        } else {
            val jsArray = Gson().toJson(JSONArray(entityProperty))
            Gson().toJson(jsArray)
        }
    }

    override fun convertToEntityProperty(databaseValue: String?): List<Question>? {
        return if (databaseValue == null) {
            return arrayListOf()
        } else Gson().fromJson(databaseValue, object : TypeToken<List<Question>>() {

        }.type)
    }


}