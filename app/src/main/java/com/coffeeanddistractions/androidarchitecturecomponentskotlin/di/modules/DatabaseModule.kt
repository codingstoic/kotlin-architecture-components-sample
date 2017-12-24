package com.coffeeanddistractions.androidarchitecturecomponentskotlin.di.modules

import android.content.Context
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.ApplicationDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 * Created by Abdu on 12/24/2017.
 */

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun getDatabase(context: Context): ApplicationDatabase = ApplicationDatabase.getDBFromContext(context)

    @Singleton
    @Provides
    fun getPostDao(applicationDatabase: ApplicationDatabase) = applicationDatabase.postDao()

    @Singleton
    @Provides
    fun getCommentDao(applicationDatabase: ApplicationDatabase) = applicationDatabase.commentDao()
}