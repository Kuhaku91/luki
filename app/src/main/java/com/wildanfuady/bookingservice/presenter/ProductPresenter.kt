package com.wildanfuady.bookingservice.presenter

import android.util.Log
import com.wildanfuady.bookingservice.network.NetworkConfig
import com.wildanfuady.bookingservice.response.ResultLogin
import com.wildanfuady.bookingservice.response.ResultProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductPresenter(val productView: ProductView) {

    fun getProduct(){

        NetworkConfig.getServiceProduct()
            .getAllProduct()
            .enqueue(object : Callback<ResultProduct> {
                override fun onFailure(call: Call<ResultProduct>, t: Throwable) {
                    productView.onErrorGetProduct(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultProduct>,
                    response: Response<ResultProduct>
                ) {
                    // Log.e("debug", "response : ${response.toString()}")
                    if (response.code() == 200){
                        val data = response.body()?.product
                        productView.onSuccessGetProduct(data)
                    } else {
                        productView.onErrorGetProduct(response.message())
                    }
                }
            })
    }

    fun addProduct(product_name: String?, product_price: String?){
        NetworkConfig.getServiceProduct()
            .insertProduct(product_name, product_price)
            .enqueue(object : Callback<ResultProduct> {
                override fun onFailure(call: Call<ResultProduct>, t: Throwable) {
                    productView.onErrorGetProduct(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultProduct>,
                    response: Response<ResultProduct>
                ) {
                    // Log.e("debug", "response : ${response.toString()}")
                    if (response.code() == 200){
                        productView.onSuccessAddProduct("Berhasil menyimpan data product")
                    } else {
                        productView.onErrorGetProduct(response.message())
                    }
                }
            })
    }
}


