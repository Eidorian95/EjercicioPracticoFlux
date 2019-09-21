package com.adrianiglesia.ejerciciopracticoflux.ViewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrianiglesia.ejerciciopracticoflux.Model.UserJson
import com.adrianiglesia.ejerciciopracticoflux.Repo.UsersRepository

class MainViewModel: ViewModel() {

    private lateinit var usersList:MutableLiveData<List<UserJson.User>>

    private var repo:UsersRepository = UsersRepository()

    var isLoading = MutableLiveData<Boolean>()

    var apiError = MutableLiveData<Throwable>()


    fun getUsers():MutableLiveData<List<UserJson.User>>{
        if(!::usersList.isInitialized){
            usersList = MutableLiveData()
            loadUsers()
        }
        return usersList
    }

    private fun loadUsers() {
        isLoading.value = true

        repo.getAllUsers({

            usersList.value = it
            isLoading.value = false

        }, {

            apiError.value = it
            isLoading.value = false

        })
    }
}