package com.wildanfuady.bookingservice.presenter

import android.util.Log
import com.wildanfuady.bookingservice.network.NetworkConfig
import com.wildanfuady.bookingservice.response.ResultProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilePresenter(val profileView: ProfileView) {

    fun getProfile(user_id: Int?){

        NetworkConfig.getServiceProfile()
            .getProfile(user_id)
            .enqueue(object : Callback<ResultProfile> {
                override fun onFailure(call: Call<ResultProfile>, t: Throwable) {
                    profileView.onErrorGetProfile(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultProfile>,
                    response: Response<ResultProfile>
                ) {
                     Log.e("debug", "response : ${response.toString()}")
                    if (response.body()?.status == 200){
                        profileView.onSuccessGetProfile(response.message(), response.body()!!.user)
                    } else {
                        profileView.onErrorGetProfile(response.message())
                    }
                }
            })
    }
}