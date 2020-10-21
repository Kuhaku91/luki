package com.wildanfuady.bookingservice

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wildanfuady.bookingservice.presenter.BookingPresenter
import com.wildanfuady.bookingservice.presenter.CekTanggalView
import kotlinx.android.synthetic.main.fragment_booking.*
import java.util.*


class BookingFragment : Fragment(), CekTanggalView{

    lateinit var dpd : DatePickerDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                             savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Cek Tanggal"

        val now = Calendar.getInstance()
        val currentYear: Int = now.get(Calendar.YEAR)
        val currentMonth: Int = now.get(Calendar.MONTH)
        val currentDay: Int = now.get(Calendar.DAY_OF_MONTH)

        textTanggal.setOnClickListener {
            dpd.show()
            // Toast.makeText(context , "Test", Toast.LENGTH_LONG).show()
        }

        context?.let {
            dpd = DatePickerDialog(it , DatePickerDialog.OnDateSetListener {
                    view,
                    year,
                    monthOfYear,
                    dayOfMonth ->
                // tambahkan 0 di depan apabila tanggal < 10
                var tanggal = dayOfMonth;
                var txtTanggal: String? = null
                if(tanggal < 10){
                    txtTanggal = "0" + tanggal
                } else {
                    txtTanggal = "$tanggal"
                }
                // tambahkan 0 di depan apabila bulan < 10
                var bulan = monthOfYear + 1;
                var txtBulan: String? = null
                if(bulan < 10){
                    txtBulan = "0${bulan}"
                } else {
                    txtBulan = "$bulan"
                }
                var tanggalLahir = "${txtTanggal}-${txtBulan}-${year}"
                textTanggal.setText(tanggalLahir)
            },   currentYear, currentMonth, currentDay)
        }

        cekTanggal.setOnClickListener {
            val presenter = BookingPresenter(this)
            val tanggal = textTanggal.text.toString()
            presenter.cekTanggal(tanggal)
        }
    }

    companion object {
        fun newInstance(): BookingFragment{
            val fragment = BookingFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onSuccessCekTanggal(msg: String?) {
        val intent = Intent(activity!!, BookingAddActivity::class.java)
        var inputTanggal = textTanggal.text.toString()
        intent.putExtra("jadwal", inputTanggal)
        startActivity(intent)
        Toast.makeText(activity!!, "Tanggal tersedia. Silahkan booking sekarang!.", Toast.LENGTH_SHORT).show()
    }

    override fun onErrorCekTanggal(msg: String?) {
        Toast.makeText(activity!!, "Antrian sudah penuh! Silahkan coba di tanggal lain.", Toast.LENGTH_SHORT).show()
    }


}
