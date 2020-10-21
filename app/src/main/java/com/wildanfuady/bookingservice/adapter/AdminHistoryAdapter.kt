package com.wildanfuady.bookingservice.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.wildanfuady.bookingservice.R
import com.wildanfuady.bookingservice.model.Booking
import com.wildanfuady.bookingservice.util.Converter
import kotlinx.android.synthetic.main.admin_data_history.view.*


class AdminHistoryAdapter(
    var data: List<Booking?>  = ArrayList()) : RecyclerView.Adapter<AdminHistoryAdapter.MyHolder>() {

    fun setList(data: List<Booking?>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.admin_data_history,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
//        holder.itemView.onClick {
//            btn.clicked(data?.get(position))
//            btnProse
//        }

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: Booking?) {
            itemView.tvBooking.text = get?.bookingJadwal
            itemView.tvJenisCuci.text = get?.bookingCuci
            itemView.tvJenisKendaraan.text = get?.bookingKendaraan
            itemView.tvStatus.text = get?.bookingStatus
            itemView.tvHargaCuci.text = Converter.formatRupiah(get?.bookingHarga!!)

//            itemView.btnProses.setOnClickListener {
//                Toast.makeText(itemView.context, "Proses", Toast.LENGTH_LONG).show()
//            }
//
//            itemView.btnCancel.setOnClickListener {
//                Toast.makeText(itemView.context, "Cancel", Toast.LENGTH_LONG).show()
//            }

        }
    }

}