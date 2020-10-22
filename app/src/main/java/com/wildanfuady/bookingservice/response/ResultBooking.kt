package com.wildanfuady.bookingservice.response

data class ResultBooking (
    val message : String? = null,
    val status : Int? = 0,
    val harga : String? = null,
    val antrian : String? = null,
    val jenis_kendaraan : String? = null
)