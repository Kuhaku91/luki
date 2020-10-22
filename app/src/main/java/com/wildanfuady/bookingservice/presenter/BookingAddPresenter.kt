package com.wildanfuady.bookingservice.presenter

import android.util.Log
import com.wildanfuady.bookingservice.network.NetworkConfig
import com.wildanfuady.bookingservice.response.ResultBooking
import com.wildanfuady.bookingservice.response.ResultCekTanggal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingAddPresenter(val bookingView: BookingView) {

    fun bookingAdd(jadwal: String?, id: Int?, no_plat: String?, jenis_kendaraan: String?, jenis_cuci: String?): Boolean{
        NetworkConfig.getServiceBooking()
            .bookingAdd(jadwal, id, no_plat, jenis_kendaraan, jenis_cuci)
            .enqueue(object : Callback<ResultBooking> {

                override fun onFailure(call: Call<ResultBooking>, t: Throwable) {
                    bookingView.onErrorBooking(t.localizedMessage, "")
                }

                override fun onResponse(
                    call: Call<ResultBooking>,
                    response: Response<ResultBooking?>
                ) {
                    if (response.body()?.status == 200){
                        Log.e("debug", "$response")
                        bookingView.onSuccessBooking(response.message(), response.body()!!.harga, response.body()!!.antrian, response.body()!!.jenis_kendaraan)
                    } else {
                        Log.e("debug", "$response")
                        bookingView.onErrorBooking(response.message(), response.body()!!.message)
                    }
                }
            })
        return true
    }

}