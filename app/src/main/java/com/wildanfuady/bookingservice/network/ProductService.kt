package com.wildanfuady.bookingservice.network

import com.wildanfuady.bookingservice.response.ResultProduct
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductService {

    @GET("product/index.php")
    fun getAllProduct(): Call<ResultProduct>

    @FormUrlEncoded
    @POST
    fun insertProduct(
        @Field("product_name") product_name: String?,
        @Field("product_price") product_price: String?
    ) : Call<ResultProduct>

}