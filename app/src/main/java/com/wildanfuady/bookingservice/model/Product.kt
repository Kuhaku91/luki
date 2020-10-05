package com.wildanfuady.bookingservice.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Product : Serializable {

    @field:SerializedName("product_id")
    val productId : Int? = 0
    @field:SerializedName("product_name")
    var productName : String? = null
    @field:SerializedName("product_price")
    var productPrice : String? = null
    @field:SerializedName("created_at")
    val createdAt : String? = null
    @field:SerializedName("updated_at")
    val updatedAt : String? = null
}