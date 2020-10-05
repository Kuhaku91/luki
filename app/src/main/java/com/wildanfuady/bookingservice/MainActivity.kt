package com.wildanfuady.bookingservice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_history -> {
                var fragment = HistoryFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_booking -> {
                var fragment = BookingFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                var fragment = ProfileFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun setActionBarTitle(title: String?) {
        supportActionBar?.setTitle(title)
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences(
            "com.wildanfuady.bookingservice",
            Context.MODE_PRIVATE
        )

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        var fragment = HistoryFragment.newInstance()
        addFragment(fragment)

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
