package com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity

/*
 * Created by Abdu on 12/24/2017.
 */
interface PostRepositoryContract {
    fun getPosts(): LiveData<PagedList<PostEntity>>
    fun getPostById(id: Long): LiveData<PostEntity>
}