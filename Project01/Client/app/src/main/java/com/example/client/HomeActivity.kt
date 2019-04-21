package com.example.client

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        loginButton.setOnClickListener {
            toast("Login")
        }


        signUpButton.setOnClickListener {
            toast("SignUp")
        }
    }


}
