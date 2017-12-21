package com.coffeeanddistractions.androidarchitecturecomponentskotlin.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/*
 * Created by Abdu on 12/21/2017.
 */

@Dao
interface PostDaoContract {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createPost(post: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: Array<PostEntity>)

    @Query("select * from posts")
    fun queryAllPosts() : LiveData<Array<PostEntity>>
}
