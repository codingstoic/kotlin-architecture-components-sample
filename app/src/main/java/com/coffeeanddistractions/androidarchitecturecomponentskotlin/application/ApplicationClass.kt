package com.coffeeanddistractions.androidarchitecturecomponentskotlin.application

import android.app.Application
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.di.component.DaggerPostViewModelComponent
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.di.component.DaggerSinglePostViewModelComponent
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.di.modules.ContextModule

/*
 * Created by Abdu on 12/20/2017.
 */

class ApplicationClass : Application() {
    val postViewModelComponent = DaggerPostViewModelComponent.
            builder().
            contextModule(ContextModule(this)).
            build()

    val singlePostViewModelComponent = DaggerSinglePostViewModelComponent.
            builder().
            contextModule(ContextModule(this)).
            build()
}