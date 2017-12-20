package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.viewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.application.ApplicationClass
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserEntity

/*
 * Created by Abdu on 12/20/2017.
 */

class UserViewModel(applicationClass: Application) : AndroidViewModel(applicationClass) {
    val userRepository = (applicationClass as ApplicationClass).getUserRepository()
    fun getAllUsers(): LiveData<Array<UserEntity>> = userRepository.getUsers()
}
