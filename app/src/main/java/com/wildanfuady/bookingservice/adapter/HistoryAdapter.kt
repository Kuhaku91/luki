package com.wildanfuady.bookingservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wildanfuady.bookingservice.R
import com.wildanfuady.bookingservice.model.Booking
import com.wildanfuady.bookingservice.util.Converter
import kotlinx.android.synthetic.main.history_data.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class HistoryAdapter(
    var data: List<Booking?>  = ArrayList()) : RecyclerView.Adapter<HistoryAdapter.MyHolder>() {

    fun setList(data: List<Booking?>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_data,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
//        holder.itemView.onClick {
//            click.clicked(data?.get(position))
//        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: Booking?) {
            itemView.tvBooking.text = get?.bookingJadwal
            itemView.tvJenisCuci.text = get?.bookingCuci
            itemView.tvJenisKendaraan.text = get?.bookingKendaraan
            itemView.tvStatus.text = get?.bookingStatus
            itemView.tvHargaCuci.text = Converter.formatRupiah(get?.bookingHarga!!)
        }
    }

}