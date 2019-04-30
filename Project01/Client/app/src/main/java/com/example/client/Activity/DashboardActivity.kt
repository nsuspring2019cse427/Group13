package com.example.client.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.client.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("Email")

        if (!name.isNullOrBlank() && !email.isNullOrEmpty()) {
            nameTV.text = name
            emailTV.text = email
        }

    }
}
