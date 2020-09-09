package com.wildanfuady.bookingservice.presenter

import com.wildanfuady.bookingservice.model.User
import com.wildanfuady.bookingservice.network.NetworkConfig
import com.wildanfuady.bookingservice.response.ResultLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView: LoginView) {

    fun login(username: String?, password: String?): Boolean{
        NetworkConfig.getServiceLogin()
            .login(username, password)
            .enqueue(object : Callback<ResultLogin> {

                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorLogin(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultLogin>,
                    response: Response<ResultLogin?>
                ) {
                    if (response.body()?.status == 200){
                        loginView.onSuccessLogin(response.message(), response.body()!!.user)
                    } else {
                        loginView.onErrorLogin(response.message())
                    }
                }
            })
        return true
    }

}