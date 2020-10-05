package com.wildanfuady.bookingservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wildanfuady.bookingservice.presenter.RegisterPresenter
import com.wildanfuady.bookingservice.presenter.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick

class RegisterActivity : AppCompatActivity(), RegisterView {

    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Sukses"
            message = "Berhasil melakukan register"
        }.show()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onErrorRegister(msg: String?) {
        alert {
            title = "Maaf"
            message = "Gagal melakukan register"
        }.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        btn_register.onClick {
            prosesRegister()
        }

        // click link login
        text_link_login.setOnClickListener {
            goToLogin()
        }
    }

    private fun prosesRegister(){

        val presenter = RegisterPresenter(this)

        val nama        = full_name.text.toString()
        val username    = username.text.toString()
        val password    = password.text.toString()
        val noHp        = no_hp.text.toString()

        presenter.register(username, nama, password, noHp)

    }

    private fun goToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}
