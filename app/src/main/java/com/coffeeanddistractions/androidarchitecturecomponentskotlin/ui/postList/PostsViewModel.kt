package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.postList

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.application.ApplicationClass
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.PostRepositoryContract
import javax.inject.Inject

/*
 * Created by Abdu on 12/22/2017.
 */

class PostsViewModel(applicationClass: Application) : AndroidViewModel(applicationClass) {
    @Inject lateinit var postRepository: PostRepositoryContract
    init {
        (applicationClass as ApplicationClass).postViewModelComponent.inject(this)
    }

    var posts: LiveData<PagedList<PostEntity>> = postRepository.getPosts()

    fun getAllPosts(): LiveData<PagedList<PostEntity>> = posts
}
