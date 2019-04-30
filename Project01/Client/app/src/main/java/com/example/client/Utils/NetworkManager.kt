package com.example.client.Utils

import com.example.client.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkManager(private val networkCallBack: NetworkCallBack) : Callback<User> {
    override fun onResponse(call: Call<User>, response: Response<User>) {
        response.body()?.let { networkCallBack.onResponseReceived(it) }

    }

    override fun onFailure(call: Call<User>, t: Throwable) {

        networkCallBack.onResponseReceived(null)
    }


    fun signUpUSer(user: User) {
        var manager: ApiInterface = NetworkManagerInstance.getRetrofitInstance().create(ApiInterface::class.java)
        manager.saveUser(user).enqueue(this)


    }
}