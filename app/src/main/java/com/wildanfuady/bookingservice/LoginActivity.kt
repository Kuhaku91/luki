package com.wildanfuady.bookingservice

import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wildanfuady.bookingservice.model.User
import com.wildanfuady.bookingservice.presenter.LoginPresenter
import com.wildanfuady.bookingservice.presenter.LoginView
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), LoginView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.wildanfuady.bookingservice.R.layout.activity_login)
        // hide bar
        supportActionBar?.hide()
        // panggil shared preferences
        val sharedPref = getSharedPreferences(this@LoginActivity.packageName,
            Context.MODE_PRIVATE
        )
        // set session login default = false
        val isLoggedIn = sharedPref.getBoolean("isLoggedin", false)
        // set user id defaultnya = 0
        val userId = sharedPref.getInt("userId", 0)
        val userLevel = sharedPref.getString("userLevel", null)
        // jika sudah pernah login, arahkan langsung ke main activity
        if (isLoggedIn && userId != 0) {
            if(userLevel == "user") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        // jika button login di klik, maka akan diarahkan ke proses login
        btn_login.setOnClickListener {
            prosesLogin()
        }

        // text register on click
        text_link_register.setOnClickListener {
            goToRegister()
        }
    }

    private fun prosesLogin(){

        val username = username.text.toString()
        val password = password.text.toString()

        val presenter = LoginPresenter(this)
        presenter.login(username, password)

    }

    override fun onSuccessLogin(msg: String?, user: User?) {

        // memanggil fitur shared preferences
        val sharedPref = getSharedPreferences(this@LoginActivity.packageName,
            Context.MODE_PRIVATE
        )

        val editor = sharedPref.edit()

        editor.putBoolean("isLoggedin", true)

        var usrId = user!!.userId

        if (usrId != null) {
            editor.putInt("userId", usrId)
        }

        editor.putString("userLevel", user.level)

        editor.commit()

        goToHome(user.level)

    }

    override fun onErrorLogin(msg: String?) {
        Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
    }

    private fun goToHome(level: String?){
        if(level == "user") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun goToRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}
