package com.wildanfuady.bookingservice.response

import com.google.gson.annotations.SerializedName
import com.wildanfuady.bookingservice.model.Product

data class ResultProduct(
    @field:SerializedName("message")
    val message: String? = null,
    @field:SerializedName("status")
    val status: Int? = 0,
    @field:SerializedName("product")
    val product: List<Product>? = null
)