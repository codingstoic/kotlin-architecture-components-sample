package com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserDaoContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.User
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.run
import java.util.concurrent.TimeUnit

/*
 * Created by Abdu on 12/20/2017.
 */

class UserRepository(val serviceContract: ServiceContract,
                     val userDaoContract: UserDaoContract){
    fun getUsers(): LiveData<PagedList<UserEntity>>{
//        launch(UI) {
//            val allUsers = run(CommonPool) {
//                delay(2, TimeUnit.SECONDS)
//                arrayOf(User(1, "Abdu", "abdu@email.com"))
//            }
//
//            userDaoContract.insertUser()
//        }

        return LivePagedListBuilder(userDaoContract.queryAllUsers(), 10).build()
    }
}
