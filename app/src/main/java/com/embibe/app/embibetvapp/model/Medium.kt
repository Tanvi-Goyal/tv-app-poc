package com.embibe.app.embibetvapp.model

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Medium {
    @Id
    var id: Long = 0
    @SerializedName("url")
    val url: String = ""
    @SerializedName("width")
    val width: Int = 0
    @SerializedName("height")
    val height: Int = 0
}
