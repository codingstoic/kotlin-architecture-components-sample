package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.singlePost

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.application.ApplicationClass
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.CommentEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.CommentRepositoryContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository.PostRepositoryContract
import javax.inject.Inject

/*
 * Created by Abdu on 12/24/2017.
 */

class SinglePostViewModel(applicationClass: Application) : AndroidViewModel(applicationClass) {
    @Inject lateinit var postRepository : PostRepositoryContract
    @Inject lateinit var commentsRepository : CommentRepositoryContract

    init {
        (applicationClass as ApplicationClass).singlePostViewModelComponent.inject(this)
    }

    private var post: LiveData<PostEntity>? = null
    private var comments: LiveData<PagedList<CommentEntity>>? = null

    fun getPostById(id: Long): LiveData<PostEntity>? {
        if(post == null){
            post = postRepository.getPostById(id)
        }

        return post
    }

    fun getCommentsForPostId(id: Long): LiveData<PagedList<CommentEntity>>?{
        if(comments == null){
            comments = commentsRepository.getCommentsForPostId(id)
        }

        return comments
    }
}
