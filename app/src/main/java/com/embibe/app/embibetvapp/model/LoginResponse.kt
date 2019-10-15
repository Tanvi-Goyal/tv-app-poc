package com.embibe.app.embibetvapp.model

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class LoginResponse {
    @Id
    var id: Long = 0
    @SerializedName("success")
    var success: Boolean = false
    @SerializedName("message")
    var message: String = ""
    @SerializedName("email")
    var email: String = ""
    @SerializedName("first_name")
    var first_name: String = ""
    @SerializedName("last_name")
    var last_name: String = ""
    @SerializedName("city")
    var city: String = ""
    @SerializedName("user_id")
    var user_id: Long = 0
    @SerializedName("mobile")
    var mobile: Long = 0
    @SerializedName("verified_email")
    var verified_email: String = ""
    @SerializedName("verified_mobile")
    var verified_mobile: Long = 0
}