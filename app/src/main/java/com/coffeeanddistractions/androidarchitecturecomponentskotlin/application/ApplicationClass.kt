package com.coffeeanddistractions.androidarchitecturecomponentskotlin.application

import android.app.Application
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.ApplicationDatabase
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.UserRepository
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientDefinition
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientImplementation

/*
 * Created by Abdu on 12/20/2017.
 */

class ApplicationClass : Application() {
    lateinit private var serviceClientImplementationInstance: ServiceClientDefinition
    lateinit private var userRepositoryInstance: UserRepository
    lateinit private var applicationDatabase : ApplicationDatabase

    override fun onCreate() {
        super.onCreate()

        serviceClientImplementationInstance = ServiceClientImplementation()
        applicationDatabase = ApplicationDatabase.getDBFromContext(this)
        userRepositoryInstance = UserRepository(serviceClientImplementationInstance, applicationDatabase.userDao())
    }

    fun getServiceImplementation(): ServiceClientDefinition = serviceClientImplementationInstance
    fun getAppDatabase(): ApplicationDatabase = applicationDatabase
    fun getUserRepository(): UserRepository = userRepositoryInstance
}