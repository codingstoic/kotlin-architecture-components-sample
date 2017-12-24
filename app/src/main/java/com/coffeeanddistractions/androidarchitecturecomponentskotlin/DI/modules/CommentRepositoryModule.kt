package com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.modules

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.CommentDaoContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.CommentRepository
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.CommentRepositoryContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientDefinition
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 * Created by Abdu on 12/24/2017.
 */

@Module
class CommentRepositoryModule {
    @Singleton
    @Provides
    fun getPostRepository(
            serviceClientDefinition: ServiceClientDefinition,
            commentDaoContract: CommentDaoContract): CommentRepositoryContract =
            CommentRepository(
                    serviceClientDefinition,
                    commentDaoContract)
}