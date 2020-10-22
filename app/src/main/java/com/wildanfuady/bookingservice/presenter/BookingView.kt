package com.wildanfuady.bookingservice.presenter

interface BookingView {

    fun onSuccessBooking(msg: String?, harga: String?, antrian: String?, jenis_kendaraan: String?)
    fun onErrorBooking(msg: String?, message: String?)

}