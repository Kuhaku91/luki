package com.wildanfuady.bookingservice.presenter

import com.wildanfuady.bookingservice.model.User

interface LoginView {

    fun onSuccessLogin(msg: String?, user: User?)
    fun onErrorLogin(msg: String?)

}