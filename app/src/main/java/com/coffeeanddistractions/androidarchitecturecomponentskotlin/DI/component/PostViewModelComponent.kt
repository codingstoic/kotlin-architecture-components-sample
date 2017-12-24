package com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.component

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.modules.ContextModule
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.modules.DatabaseModule
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.modules.PostRepositoryModule
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.modules.ServiceClientModule
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.postList.PostsViewModel
import dagger.Component
import javax.inject.Singleton

/*
 * Created by Abdu on 12/24/2017.
 */

@Component(
        modules = arrayOf(
                ContextModule::class,
                DatabaseModule::class,
                ServiceClientModule::class,
                PostRepositoryModule::class)
)
@Singleton
interface PostViewModelComponent{
    fun inject(into: PostsViewModel)
}