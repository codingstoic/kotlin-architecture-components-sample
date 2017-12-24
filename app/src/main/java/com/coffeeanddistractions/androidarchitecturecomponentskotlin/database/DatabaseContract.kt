package com.coffeeanddistractions.androidarchitecturecomponentskotlin.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/*
 * Created by Abdu on 12/20/2017.
 */

@Database(version = 6, entities = arrayOf(UserEntity::class, PostEntity::class, CommentEntity::class), exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract public fun userDao(): UserDaoContract
    abstract public fun postDao(): PostDaoContract
    abstract public fun commentDao(): CommentDaoContract

    companion object {
        private var db: ApplicationDatabase? = null

        fun getDBFromContext(context: Context): ApplicationDatabase {
            if (db == null) {
                db = Room.
                        databaseBuilder(context, ApplicationDatabase::class.java, "application-database").
                        fallbackToDestructiveMigration().
                        build()
            }

            return db as ApplicationDatabase
        }
    }
}
