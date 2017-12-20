package com.coffeeanddistractions.androidarchitecturecomponentskotlin.services

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.User

/*
 * Created by Abdu on 12/20/2017.
 */

class ServiceContractImplementation : ServiceContract {
    suspend override fun getUser(userId: Long): User {
        // use retrofit for this
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun updateUser(userId: Long, user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}