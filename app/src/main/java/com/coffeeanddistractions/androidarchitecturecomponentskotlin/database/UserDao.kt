package com.coffeeanddistractions.androidarchitecturecomponentskotlin.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/*
 * Created by Abdu on 12/20/2017.
 */

@Dao
interface UserDaoContract {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: Array<UserEntity>)

    @Query("select * from users")
//    fun queryAllUsers() : DataSource.Factory<Int, UserEntity>
    fun queryAllUsers() : LiveData<Array<UserEntity>>
}

