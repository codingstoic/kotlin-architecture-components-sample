package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.UserRepository

/*
 * Created by Abdu on 12/20/2017.
 */

class UserViewModel(val userRepository: UserRepository) : ViewModel() {
    private val allUsers: MutableLiveData<PagedList<UserEntity>> = MutableLiveData()

    fun getAllUsers(): LiveData<PagedList<UserEntity>> {
        allUsers.value = userRepository.getUsers().value

        return allUsers
    }
}
