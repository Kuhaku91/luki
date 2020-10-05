package com.wildanfuady.bookingservice.network

import com.wildanfuady.bookingservice.response.ResultProfile
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileService {

    @GET("getProfile.php")
    fun getProfile(
        @Query("user_id") user_id: Int?
    ) : Call<ResultProfile>
}