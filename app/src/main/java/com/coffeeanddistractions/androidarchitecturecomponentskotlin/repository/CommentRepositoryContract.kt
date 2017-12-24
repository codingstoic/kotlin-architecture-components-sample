package com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.CommentEntity

/*
 * Created by Abdu on 12/24/2017.
 */

interface CommentRepositoryContract {
    fun getCommentsForPostId(id: Long): LiveData<PagedList<CommentEntity>>
}