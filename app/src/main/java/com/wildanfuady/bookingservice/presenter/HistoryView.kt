package com.wildanfuady.bookingservice.presenter

import com.wildanfuady.bookingservice.model.Booking

interface HistoryView {


    fun onSuccessGetHistory(msg: String?, bookings: List<Booking>?)
    fun onErrorGetHistory(msg: String?)
}