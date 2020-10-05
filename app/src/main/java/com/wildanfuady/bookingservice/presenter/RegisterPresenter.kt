package com.wildanfuady.bookingservice.presenter

import android.util.Log
import com.wildanfuady.bookingservice.network.NetworkConfig
import com.wildanfuady.bookingservice.response.ResultRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {

    fun register(username: String?, full_name: String?, password: String?, no_hp: String?){
        NetworkConfig.getServiceRegister()
            .register(username, full_name, password, no_hp)
            .enqueue(object : Callback<ResultRegister> {

                override fun onFailure(call: Call<ResultRegister>, t: Throwable) {
                    registerView.onErrorRegister(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultRegister>,
                    response: Response<ResultRegister>
                ) {
                    Log.e("debug", "response ${response}")

                    if (response.body()?.status == 200){
                        registerView.onSuccessRegister(response?.message())
                    } else {
                        registerView.onErrorRegister(response?.message())
                    }
                }
            })
    }

}