package com.adrianiglesia.ejerciciopracticoflux.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrianiglesia.ejerciciopracticoflux.Model.User
import com.adrianiglesia.ejerciciopracticoflux.Repo.UsersRepository

class MainViewModel: ViewModel() {

    private lateinit var usersList:MutableLiveData<List<User>>

    private var repo:UsersRepository = UsersRepository()

    var isLoading = MutableLiveData<Boolean>()

    var apiError = MutableLiveData<Throwable>()


    fun getUsers():MutableLiveData<List<User>>{
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