package com.coffeeanddistractions.androidarchitecturecomponentskotlin.application

import android.app.Application
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.ApplicationDatabase
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.PostRepository
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.UserRepository
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientDefinition
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientImplementation

/*
 * Created by Abdu on 12/20/2017.
 */

class ApplicationClass : Application() {
    lateinit private var serviceClientImplementationInstance: ServiceClientDefinition
    lateinit private var userRepositoryInstance: UserRepository
    lateinit private var postRepositoryInstance: PostRepository
    lateinit private var applicationDatabase : ApplicationDatabase

    override fun onCreate() {
        super.onCreate()

        serviceClientImplementationInstance = ServiceClientImplementation()
        applicationDatabase = ApplicationDatabase.getDBFromContext(this)
        userRepositoryInstance = UserRepository(serviceClientImplementationInstance, applicationDatabase.userDao())
        postRepositoryInstance = PostRepository(serviceClientImplementationInstance, applicationDatabase.postDao())
    }

    fun getServiceImplementation(): ServiceClientDefinition = serviceClientImplementationInstance
    fun getAppDatabase(): ApplicationDatabase = applicationDatabase
    // todo add interfaces for this so this can be replaced
    fun getUserRepository(): UserRepository = userRepositoryInstance
    fun getPostRepository(): PostRepository = postRepositoryInstance
}