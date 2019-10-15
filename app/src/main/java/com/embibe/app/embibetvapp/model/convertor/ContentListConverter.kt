package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter
import org.json.JSONArray


class ContentListConverter : PropertyConverter<List<Item>?, String> {

    override fun convertToDatabaseValue(entityProperty: List<Item>?): String? {
        return if (entityProperty == null) {
            null
        } else {
            val jsArray = Gson().toJson(JSONArray(entityProperty))
            Gson().toJson(jsArray)
        }
    }

    override fun convertToEntityProperty(databaseValue: String?): List<Item>? {
        return if (databaseValue == null) {
            return arrayListOf()
        } else Gson().fromJson(databaseValue, object : TypeToken<List<Item>>() {

        }.type)
    }


}