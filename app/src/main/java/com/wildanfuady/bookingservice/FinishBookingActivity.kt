package com.wildanfuady.bookingservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wildanfuady.bookingservice.util.Converter
import kotlinx.android.synthetic.main.activity_finish_booking.*

class FinishBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_booking)

        // supportActionBar?.setTitle("Booking Sukses")
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.hide()

        var harga = ""
        var antrian = ""
        var jenis_kendaraan = ""
        if(intent != null)
        {
            harga = intent.getStringExtra("harga")
            antrian = intent.getStringExtra("antrian")
            jenis_kendaraan = intent.getStringExtra("jenis_kendaraan")
        }
        var rupiah = Converter.formatRupiah(harga.toInt())
        textHarga.setText(rupiah)
        var jam = ""
        if(antrian == "1"){
            jam = "08.00 - 09.00"
        } else if(antrian == "2"){
            jam = "09.00 - 10.00"
        } else if(antrian == "3"){
            jam = "10.00 - 11.00"
        } else if(antrian == "4"){
            jam = "11.00 - 12.00"
        } else if(antrian == "5"){
            jam = "13.00 - 14.00"
        } else {
            jam = ""
        }
        textNoAntrian.setText(antrian)
        textJam.setText(jam)
        textHarga.setText(rupiah)
        textJenisKendaraan.setText(jenis_kendaraan)

        btnBackToHome.setOnClickListener {
            backToHome()
        }
    }

    private fun backToHome(){

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}
