package com.wildanfuady.bookingservice.presenter

import android.util.Log
import com.wildanfuady.bookingservice.network.NetworkConfig
import com.wildanfuady.bookingservice.response.ResultHistory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryPresenter(val historyView: HistoryView) {

    fun getHistory(user_id: Int?): Boolean{
        NetworkConfig.getServiceBooking()
            .getHistory(user_id)
            .enqueue(object : Callback<ResultHistory> {

                override fun onFailure(call: Call<ResultHistory>, t: Throwable) {
                    historyView.onErrorGetHistory(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultHistory>,
                    response: Response<ResultHistory?>
                ) {
                    if (response.body()?.status == 200){
                        Log.e("debug", "$response")
                        val data = response.body()!!.bookings
                        historyView.onSuccessGetHistory(response.message(), data)
                    } else {
                        historyView.onErrorGetHistory(response.message())
                    }
                }
            })
        return true
    }

    fun getHistoryFromAdmin(): Boolean{
        NetworkConfig.getServiceBooking()
            .getHistoryFromAdmin()
            .enqueue(object : Callback<ResultHistory> {

                override fun onFailure(call: Call<ResultHistory>, t: Throwable) {
                    historyView.onErrorGetHistory(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultHistory>,
                    response: Response<ResultHistory?>
                ) {
                    if (response.body()?.status == 200){
                        Log.e("debug", "$response")
                        val data = response.body()!!.bookings
                        historyView.onSuccessGetHistory(response.message(), data)
                    } else {
                        historyView.onErrorGetHistory(response.message())
                    }
                }
            })
        return true
    }
}