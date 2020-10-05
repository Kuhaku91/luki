package com.wildanfuady.bookingservice.presenter

import android.util.Log
import com.wildanfuady.bookingservice.BookingFragment
import com.wildanfuady.bookingservice.network.NetworkConfig
import com.wildanfuady.bookingservice.response.ResultCekTanggal
import com.wildanfuady.bookingservice.response.ResultHistory
import com.wildanfuady.bookingservice.response.ResultLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingPresenter(val cekTanggalView: CekTanggalView) {

    fun cekTanggal(tanggal: String?): Boolean{
        NetworkConfig.getServiceBooking()
            .cekTanggal(tanggal)
            .enqueue(object : Callback<ResultCekTanggal> {

                override fun onFailure(call: Call<ResultCekTanggal>, t: Throwable) {
                    cekTanggalView.onErrorCekTanggal(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultCekTanggal>,
                    response: Response<ResultCekTanggal?>
                ) {
                    if (response.body()?.status == 200){
                        // Log.e("debug", "$response")
                        cekTanggalView.onSuccessCekTanggal(response.message())
                    } else {
                        cekTanggalView.onErrorCekTanggal(response.message())
                    }
                }
            })
        return true
    }



}