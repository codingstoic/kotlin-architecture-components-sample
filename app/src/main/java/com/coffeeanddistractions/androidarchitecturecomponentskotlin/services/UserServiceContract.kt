package com.coffeeanddistractions.androidarchitecturecomponentskotlin.services

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.User

/*
 * Created by Abdu on 12/20/2017.
 */

interface UserServiceContract {
    suspend fun getUser(userId: Long): User
    suspend fun getAllUsers(): Array<User>
    suspend fun updateUser(userId: Long, user: User)
}
