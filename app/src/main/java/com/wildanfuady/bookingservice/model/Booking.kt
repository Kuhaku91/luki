package com.wildanfuady.bookingservice.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Booking : Serializable {

    @field:SerializedName("booking_id")
    val bookingId: Int? = 0
    @field:SerializedName("booking_jadwal")
    val bookingJadwal: String? = null
    @field:SerializedName("booking_kendaraan")
    val bookingKendaraan: String? = null
    @field:SerializedName("booking_cuci")
    val bookingCuci: String? = null
    @field:SerializedName("booking_plat")
    val bookingPlat: String? = null
    @field:SerializedName("user_id")
    val userId: Int? = null
    @field:SerializedName("booking_harga")
    val bookingHarga: Int? = 0
    @field:SerializedName("booking_status")
    val bookingStatus: String? = null
    @field:SerializedName("created_at")
    val createdAt: String? = null
    @field:SerializedName("updated_at")
    val updatedAt: String? = null
}