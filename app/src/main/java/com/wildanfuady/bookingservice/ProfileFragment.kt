package com.wildanfuady.bookingservice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.wildanfuady.bookingservice.model.User
import com.wildanfuady.bookingservice.presenter.ProfilePresenter
import com.wildanfuady.bookingservice.presenter.ProfileView
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment(), ProfileView {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Profile"

        btnLogout.setOnClickListener {
            logout()
        }

        val sharedPref = activity!!.getSharedPreferences(activity!!.packageName,
            Context.MODE_PRIVATE
        )

        val userId = sharedPref.getInt("userId", 0)
        Log.e("debug", "{$userId}")
        val presenter = ProfilePresenter(this)
        presenter.getProfile(userId)

    }

    override fun onSuccessGetProfile(msg: String?, user: User?) {

        txt_username.text = user?.username
        txt_fullname.text = user?.fullName
        txt_phone.text = user?.noHp

    }

    override fun onErrorGetProfile(msg: String?) {
        Toast.makeText(activity!!, "Gagal mengambil data profile", Toast.LENGTH_SHORT).show()
    }

    fun logout(){
        // masuk session ke state
        val sharedPref = activity!!.getSharedPreferences(activity!!.packageName,
            Context.MODE_PRIVATE
        )

        val editor = sharedPref.edit()
        editor.putBoolean("isLoggedin", false)
        editor.putInt("userId", 0)
        editor.commit()

        goToLogin()
    }

    private fun goToLogin(){
        val intent = Intent(activity!!, LoginActivity::class.java)
        startActivity(intent)
        activity!!.finish()
    }

    companion object {
        fun newInstance(): ProfileFragment{
            val fragment = ProfileFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
