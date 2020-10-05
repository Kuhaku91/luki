package com.wildanfuady.bookingservice.presenter

import com.wildanfuady.bookingservice.model.User

interface ProfileView {

    fun onSuccessGetProfile(msg: String?, user: User?)
    fun onErrorGetProfile(msg: String?)
}