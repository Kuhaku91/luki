package com.wildanfuady.bookingservice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wildanfuady.bookingservice.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences(
            "com.wildanfuady.bookingservice",
            Context.MODE_PRIVATE
        )

        val userId = sharedPref.getInt("userId", 0)
        val userLevel = sharedPref.getString("userLevel", "user")

        name.text = userId.toString() + " as " + userLevel

        btn_logout.setOnClickListener {
            prosesLogout()
        }

    }

    private fun prosesLogout(){
        // masuk session ke state
        val sharedPref = getSharedPreferences(this@MainActivity.packageName,
            Context.MODE_PRIVATE
        )

        val editor = sharedPref.edit()
        editor.putBoolean("isLoggedin", false)
        editor.putInt("userId", 0)
        editor.commit()

        goToLogin()
    }

    private fun goToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
