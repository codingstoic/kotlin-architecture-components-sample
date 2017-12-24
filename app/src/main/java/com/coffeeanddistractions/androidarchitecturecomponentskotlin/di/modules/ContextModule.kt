package com.coffeeanddistractions.androidarchitecturecomponentskotlin.di.modules

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