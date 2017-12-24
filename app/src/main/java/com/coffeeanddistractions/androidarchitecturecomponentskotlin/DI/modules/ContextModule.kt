package com.coffeeanddistractions.androidarchitecturecomponentskotlin.DI.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 * Created by Abdu on 12/24/2017.
 */

@Module
class ContextModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideContext(): Context = context
}