package com.adrianiglesia.ejerciciopracticoflux.Repo

import android.util.Log
import com.adrianiglesia.ejerciciopracticoflux.Model.UserJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepository {

    fun getAllUsers(successHandler: (List<UserJson.User>?)->Unit, failureHandler: (Throwable?)-> Unit){
        var users:Call<UserJson> = MyRetrofit.getClient.getAllUsers()
        users.enqueue(object : Callback<UserJson>{
            override fun onFailure(call: Call<UserJson>, t: Throwable) {
                Log.d("ERROR", "Ups! Algo malio sal!")
                failureHandler(t)
            }
            override fun onResponse(call: Call<UserJson>, response: Response<UserJson>) {
                Log.d("RESPONSE",response.body().toString())
                response.body()?.let {
                    successHandler(it.users)
                }
            }
        })
    }
}