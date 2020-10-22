package com.wildanfuady.bookingservice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import com.wildanfuady.bookingservice.presenter.BookingAddPresenter
import com.wildanfuady.bookingservice.presenter.BookingView
import kotlinx.android.synthetic.main.activity_booking_add.*

class BookingAddActivity : AppCompatActivity(), BookingView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_add)

        supportActionBar?.setTitle("Tambah Booking")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnBooking.setOnClickListener {
            prosesBooking()
        }
    }

    fun prosesBooking(){
        // ambil jadwal
        var getTanggal = intent.getStringExtra("jadwal")
        // ambil user id
        val sharedPref = getSharedPreferences(this@BookingAddActivity.packageName,
            Context.MODE_PRIVATE
        )
        val userId = sharedPref.getInt("userId", 0)
        var plat_nomor = inputPlatNomor.text.toString()
        var jenis_kendaraan = spinnerJenisKendaraan.selectedItem.toString()
        var jenis_cuci = spinnerJenisCuci.selectedItem.toString()

        val presenter = BookingAddPresenter(this)
        presenter.bookingAdd(getTanggal, userId, plat_nomor, jenis_kendaraan, jenis_cuci)
    }

    override fun onSuccessBooking(msg: String?, harga: String?, antrian: String?, jenis_kendaraan: String?) {
        Toast.makeText(this, "Selamat! Anda berhasil melakukan booking.", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, FinishBookingActivity::class.java)
        intent.putExtra("harga", harga)
        intent.putExtra("antrian", antrian)
        intent.putExtra("jenis_kendaraan", jenis_kendaraan)
        startActivity(intent)
        finish()
    }

    override fun onErrorBooking(msg: String?, message: String?) {
         Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
