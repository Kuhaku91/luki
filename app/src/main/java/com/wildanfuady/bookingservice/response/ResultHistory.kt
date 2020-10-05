package com.wildanfuady.bookingservice.response

import com.wildanfuady.bookingservice.model.Booking

data class ResultHistory (

    val message : String,
    val status : Int,
    val bookings : List<Booking>
)