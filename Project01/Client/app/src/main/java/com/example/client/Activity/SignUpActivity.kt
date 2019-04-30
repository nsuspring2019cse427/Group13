package com.example.client.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.client.R
import com.example.client.User
import com.example.client.Utils.NetworkCallBack
import com.example.client.Utils.NetworkManager
import com.example.client.Utils.Validator
import com.example.client.toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), NetworkCallBack {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        signUpBtn.setOnClickListener { signUpBtnView ->

            performSaveUser()

        }
    }

    private fun performSaveUser() {
        var username: String = userNameET.text.toString()
        var email: String = emailET.text.toString()
        var password: String = passwordET.text.toString()
        var confirmPassword: String = confirmPasswordEt.text.toString()


        val isValid: Boolean = Validator().validateUserInfo(email = email, password = password, confirmPassword = confirmPassword, username = username)


        if (isValid) {
            saveUserToServer(User(username, password, confirmPassword, email))
        } else {
            toast("Please correct given information")
        }
    }

    private fun saveUserToServer(user: User) {

        NetworkManager(this).signUpUSer(user)

    }

    override fun onResponseReceived(data: Any?) {

        data.let {
            try {
                var userData = it as User
                userData.let {
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.putExtra("Email", it.email)
                    intent.putExtra("Name", it.userName)
                    startActivity(intent)
                }
            } catch (e: Exception) {
            }
        }
    }


}
