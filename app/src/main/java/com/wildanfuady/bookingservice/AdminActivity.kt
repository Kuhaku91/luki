package com.wildanfuady.bookingservice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildanfuady.bookingservice.adapter.AdminHistoryAdapter
import com.wildanfuady.bookingservice.adapter.HistoryAdapter
import com.wildanfuady.bookingservice.model.Booking
import com.wildanfuady.bookingservice.presenter.HistoryPresenter
import com.wildanfuady.bookingservice.presenter.HistoryView
import kotlinx.android.synthetic.main.admin_history_adapter.*
import kotlinx.android.synthetic.main.history_adapter.*

class AdminActivity : AppCompatActivity(), HistoryView {

    var adapter = AdminHistoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_history_adapter)

        supportActionBar?.setTitle("Administrator")

        val presenter = HistoryPresenter(this)
        presenter.getHistoryFromAdmin()

        listViewHistoryAdmin.layoutManager = LinearLayoutManager(this)
        listViewHistoryAdmin.adapter = adapter

    }

    override fun onSuccessGetHistory(msg: String?, bookings: List<Booking>?) {
        bookings?.let {
            adapter.setList(bookings)

        }
    }

    override fun onErrorGetHistory(msg: String?) {
        Toast.makeText(this, "Belum ada data transaksi", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_logout){
            // masuk session ke state
            val sharedPref = this.getSharedPreferences(this.packageName,
                Context.MODE_PRIVATE
            )

            val editor = sharedPref.edit()
            editor.putBoolean("isLoggedin", false)
            editor.putInt("userId", 0)
            editor.putString("userLevel", null)
            editor.commit()

            goToLogin()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
