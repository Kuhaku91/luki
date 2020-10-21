package com.wildanfuady.bookingservice

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildanfuady.bookingservice.adapter.HistoryAdapter
import com.wildanfuady.bookingservice.model.Booking
import com.wildanfuady.bookingservice.presenter.HistoryPresenter
import com.wildanfuady.bookingservice.presenter.HistoryView
import kotlinx.android.synthetic.main.history_adapter.*

class HistoryFragment : Fragment(), HistoryView {

    var adapter = HistoryAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.history_adapter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listViewHistory.layoutManager = LinearLayoutManager(context)
        listViewHistory.adapter = adapter

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "My History"

        // ambil id user yang login

        val sharedPref = activity!!.getSharedPreferences(activity!!.packageName,
            Context.MODE_PRIVATE
        )

        val userId = sharedPref.getInt("userId", 0)
        Log.e("debug", "{$userId}")

        // parameter id user dikirim ke server
        val presenter = HistoryPresenter(this)
        presenter.getHistory(userId)

    }

    override fun onErrorGetHistory(msg: String?) {

        Toast.makeText(activity!!, "Selamat datang! Anda sudah bisa melakukan order cuci mobil sekarang.", Toast.LENGTH_SHORT).show()

    }

    override fun onSuccessGetHistory(msg: String?, bookings: List<Booking>?) {

        bookings?.let {
            adapter.setList(bookings)

        }

    }

    companion object {
        fun newInstance(): HistoryFragment{
            val fragment = HistoryFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
