package com.wildanfuady.bookingservice.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User : Serializable {

    @field:SerializedName("user_id")
    val userId : Int? = 0
    @field:SerializedName("username")
    var username : String? = null
    @field:SerializedName("fullname")
    var fullName : String? = null
    @field:SerializedName("password")
    val password : String? = null
    @field:SerializedName("status")
    val status : String? = null
    @field:SerializedName("level")
    val level : String? = null
    @field:SerializedName("no_hp")
    var noHp : String ? = null
    @field:SerializedName("created_at")
    val createdAt : String? = null
    @field:SerializedName("updated_at")
    val updatedAt : String? = null

}