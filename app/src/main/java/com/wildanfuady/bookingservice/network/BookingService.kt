package com.wildanfuady.bookingservice.network

import com.wildanfuady.bookingservice.response.ResultBooking
import com.wildanfuady.bookingservice.response.ResultCekTanggal
import com.wildanfuady.bookingservice.response.ResultHistory
import retrofit2.Call
import retrofit2.http.*

interface BookingService {

    @FormUrlEncoded
    @POST("cekTanggal.php")
    fun cekTanggal(
        @Field("tanggal") tanggal: String?
    ) : Call<ResultCekTanggal>

    @FormUrlEncoded
    @POST("bookingAdd.php")
    fun bookingAdd(
        @Field("jadwal") jadwal: String?,
        @Field("user_id") user_id: Int?,
        @Field("no_plat") no_plat: String?,
        @Field("jenis_kendaraan") jenis_kendaraan: String?,
        @Field("jenis_cuci") jenis_cuci: String?
    ) : Call<ResultBooking>

    @GET("getHistory.php")
    fun getHistory(
        @Query("user_id") user_id: Int?
    ) : Call<ResultHistory>

    @GET("admin/getHistory.php")
    fun getHistoryFromAdmin() : Call<ResultHistory>
}