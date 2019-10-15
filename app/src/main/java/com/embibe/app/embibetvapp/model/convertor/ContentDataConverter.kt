package com.embibe.app.embibetvapp.model.convertor

import com.embibe.app.embibetvapp.model.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter

class ContentDataConverter : PropertyConverter<Item, String> {

    override fun convertToDatabaseValue(entityProperty: Item?): String? {
        return if (entityProperty == null) {
            null
        } else Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): Item? {
        return if (databaseValue == null) {
            return null
        } else Gson().fromJson(databaseValue, object : TypeToken<Item>() {
        }.type)
    }


}