package com.embibe.app.embibetvapp.model

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
class ContentDetails {
    @Id
    var id: Long = 0
    @SerializedName("duration")
    var duration: String = ""
    @SerializedName("dimension")
    var dimension: String = ""
    @SerializedName("definition")
    var definition: String = ""
    @SerializedName("caption")
    var caption: Boolean = false
    @SerializedName("licensedContent")
    var licensedContent: Boolean = false
    @SerializedName("projection")
    var projection: String = ""
}
