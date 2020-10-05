package com.wildanfuady.bookingservice.presenter

interface BookingView {

    fun onSuccessBooking(msg: String?, harga: String?)
    fun onErrorBooking(msg: String?)

}