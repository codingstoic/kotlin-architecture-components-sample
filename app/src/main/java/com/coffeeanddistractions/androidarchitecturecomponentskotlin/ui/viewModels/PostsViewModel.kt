package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.viewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.application.ApplicationClass
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity

/*
 * Created by Abdu on 12/22/2017.
 */

class PostsViewModel(applicationClass: Application) : AndroidViewModel(applicationClass) {
    val postRepository = (applicationClass as ApplicationClass).getPostRepository()
    var posts: LiveData<PagedList<PostEntity>> = postRepository.getPosts()
    fun getAllPosts(): LiveData<PagedList<PostEntity>> = posts
}
