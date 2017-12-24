package com.coffeeanddistractions.androidarchitecturecomponentskotlin.database

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/*
 * Created by Abdu on 12/24/2017.
 */

@Dao
interface CommentDaoContract{
    @Query("select * from comments where postId = :arg0")
    fun getCommentsForPostId(id: Long) : DataSource.Factory<Int, CommentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComments(comments: Array<CommentEntity>)
}