package com.wildanfuady.bookingservice.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun getInterceptor(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api-booking.ilmukoding.com/")
                // localhost/booking_service
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getServiceRegister(): RegisterService = getRetrofit().create(RegisterService::class.java)
    fun getServiceLogin(): LoginService = getRetrofit().create(LoginService::class.java)
    fun getServiceProduct(): ProductService = getRetrofit().create(ProductService::class.java)
    fun getServiceBooking(): BookingService = getRetrofit().create(BookingService::class.java)
    fun getServiceProfile(): ProfileService = getRetrofit().create(ProfileService::class.java)

}