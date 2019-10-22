package com.embibe.app.embibetvapp.model

import android.content.Context
import android.graphics.Color
import android.util.Log

import com.google.gson.annotations.SerializedName

import java.net.URI
import java.net.URISyntaxException

/**
 * This is a generic example of a custom data object, containing info we might want to keep with
 * each card on the home screen
 */
class Card {

    @SerializedName("title")
    var title = ""
    @SerializedName("subTitleOne")
    var subTitleOne = ""
    @SerializedName("subDescOne")
    var subDescOne = ""
    @SerializedName("subTitleTwo")
    var subTitleTwo = ""
    @SerializedName("subDescTwo")
    var subDescTwo = ""
    @SerializedName("card")
    var imageUrl: String? = null
    @SerializedName("selectedColor")
    private var mSelectedColor: String? = null
    @SerializedName("localImageResource")
    var localImageResource: String? = null
    @SerializedName("type")
    var type: Type? = null

    val selectedColor: Int
        get() = if (mSelectedColor == null) -1 else Color.parseColor(mSelectedColor)

    val imageURI: URI?
        get() {
            if (imageUrl == null) return null
            try {
                return URI(imageUrl!!)
            } catch (e: URISyntaxException) {
                Log.d("URI exception: ", imageUrl!!)
                return null
            }

        }

    fun setSelectedColor(selectedColor: String) {
        mSelectedColor = selectedColor
    }

    fun getLocalImageResourceId(context: Context): Int {
        return context.resources.getIdentifier(
            getLocalImageResourceName(), "drawable",
            context.packageName
        )
    }

    fun getLocalImageResourceName(): String? {
        return localImageResource
    }

    enum class Type {
        DEFAULT,
        TEXT,
        PERFORMANCE,
        CHART
    }

}
