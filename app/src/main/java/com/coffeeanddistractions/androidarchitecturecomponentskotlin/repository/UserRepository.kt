package com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository

import android.arch.lifecycle.LiveData
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserDaoContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientDefinition
import kotlinx.coroutines.experimental.launch

/*
 * Created by Abdu on 12/20/2017.
 */

class UserRepository(val serviceClientImplementation: ServiceClientDefinition,
                     val userDaoContract: UserDaoContract) {
    fun getUsers(): LiveData<Array<UserEntity>> {
        launch {
            val users = serviceClientImplementation.getAllUsers()
            val userEntities: MutableList<UserEntity> = mutableListOf()

            users.forEach {
                val userEntity = UserEntity()
                userEntity.id = it.id
                userEntity.name = it.name
                userEntity.email = it.email
                userEntities.add(userEntity)
            }

            userDaoContract.insertUsers(users = userEntities.toTypedArray())
        }

        return userDaoContract.queryAllUsers()
    }
}
