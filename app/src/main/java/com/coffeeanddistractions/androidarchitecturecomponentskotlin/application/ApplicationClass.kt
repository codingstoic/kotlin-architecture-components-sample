package com.coffeeanddistractions.androidarchitecturecomponentskotlin.application

import android.app.Application
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.ApplicationDatabase
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.UserRepository
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceContractImplementation

/*
 * Created by Abdu on 12/20/2017.
 */

class ApplicationClass : Application() {
    lateinit private var serviceImplementationInstance : ServiceContract
    lateinit private var userRepositoryInstance: UserRepository
    lateinit private var applicationDatabase : ApplicationDatabase

    override fun onCreate() {
        super.onCreate()

        serviceImplementationInstance = ServiceContractImplementation()
        applicationDatabase = ApplicationDatabase.getDBFromContext(this)
        userRepositoryInstance = UserRepository(serviceImplementationInstance, applicationDatabase.userDao())
    }

    fun getServiceImplementation(): ServiceContract = serviceImplementationInstance
    fun getAppDatabase(): ApplicationDatabase = applicationDatabase
    fun getUserRepository(): UserRepository = userRepositoryInstance
}