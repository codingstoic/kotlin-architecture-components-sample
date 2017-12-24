package com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.modules

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientDefinition
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 * Created by Abdu on 12/24/2017.
 */

@Module
class ServiceClientModule {
    @Singleton
    @Provides
    fun getServiceClientImplementation(): ServiceClientDefinition = ServiceClientImplementation()
}

