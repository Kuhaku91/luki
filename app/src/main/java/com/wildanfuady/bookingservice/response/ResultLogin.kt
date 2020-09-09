package com.wildanfuady.bookingservice.response

import com.wildanfuady.bookingservice.model.User

data class ResultLogin (
    val message : String? = null,
    val status : Int? = 0,
    val user: User ?= null
)