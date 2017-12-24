package com.coffeeanddistractions.androidarchitecturecomponentskotlin.di.modules

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostDaoContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.PostRepository
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.PostRepositoryContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientDefinition
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 * Created by Abdu on 12/24/2017.
 */

@Module
class PostRepositoryModule {
    @Singleton
    @Provides
    fun getPostRepository(
            serviceClientDefinition: ServiceClientDefinition,
            postDaoContract: PostDaoContract): PostRepositoryContract =
            PostRepository(
                    serviceClientDefinition,
                    postDaoContract)
}