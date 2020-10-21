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
        if(intent != null)
        {
            harga = intent.getStringExtra("harga")
            antrian = intent.getStringExtra("antrian")
        }
        var rupiah = Converter.formatRupiah(harga.toInt())
        textHarga.setText(rupiah)
        textNoAntrian.setText("Nomor Antrian: " + antrian)

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
