package com.coffeeanddistractions.androidarchitecturecomponentskotlin.services

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.User
import kotlinx.coroutines.experimental.delay
import java.util.concurrent.TimeUnit

/*
 * Created by Abdu on 12/20/2017.
 */

class ServiceClientImplementation : ServiceClientDefinition {
    suspend override fun getAllUsers(): Array<User> {
        val users = arrayOf(User(name = "abdu", email = "adil@email.com", id = 1 ))
        delay(5, TimeUnit.SECONDS)
        return users
    }

    suspend override fun getUser(userId: Long): User {
        // use retrofit for this
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun updateUser(userId: Long, user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}