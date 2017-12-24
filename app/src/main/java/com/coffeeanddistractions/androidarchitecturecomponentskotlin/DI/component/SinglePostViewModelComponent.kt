package com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.component

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.modules.*
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.singlePost.SinglePostViewModel
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
                PostRepositoryModule::class,
                CommentRepositoryModule::class)
)
@Singleton
interface SinglePostViewModelComponent{
    fun inject(into: SinglePostViewModel)
}
