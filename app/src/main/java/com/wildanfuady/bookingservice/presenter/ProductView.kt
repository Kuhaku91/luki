package com.wildanfuady.bookingservice.presenter

import com.wildanfuady.bookingservice.model.Product

interface ProductView {

    fun onSuccessGetProduct(product: List<Product>?)
    fun onErrorGetProduct(msg : String?)

    fun onSuccessAddProduct(msg: String?)
    fun onErrorAddProduct(msg: String?)

}