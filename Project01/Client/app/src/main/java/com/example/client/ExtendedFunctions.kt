package com.example.client

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

