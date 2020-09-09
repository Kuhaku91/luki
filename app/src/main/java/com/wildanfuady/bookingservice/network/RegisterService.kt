package com.wildanfuady.bookingservice.network

import com.wildanfuady.bookingservice.response.ResultRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegisterService {

    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("username") username: String?,
        @Field("full_name") full_name: String?,
        @Field("password") password: String?,
        @Field("no_hp") no_hp: String?
    ) : Call<ResultRegister>

}