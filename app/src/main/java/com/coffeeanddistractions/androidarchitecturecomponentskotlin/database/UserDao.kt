package com.coffeeanddistractions.androidarchitecturecomponentskotlin.database

import android.arch.paging.DataSource
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/*
 * Created by Abdu on 12/20/2017.
 */

@Dao
interface UserDaoContract {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertUser(user: UserEntity)

    @Query("select * from user")
    fun queryAllUsers() : DataSource.Factory<Int, UserEntity>
}

