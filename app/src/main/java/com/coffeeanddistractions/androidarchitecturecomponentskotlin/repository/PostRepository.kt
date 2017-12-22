package com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostDaoContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientDefinition
import kotlinx.coroutines.experimental.launch

/*
 * Created by Abdu on 12/20/2017.
 */

class PostRepository(val serviceClientImplementation: ServiceClientDefinition,
                     val postDaoContract: PostDaoContract){
    fun getPosts(): LiveData<PagedList<PostEntity>> {
        launch {
            val posts = serviceClientImplementation.getAllPosts()
            val postEntities: MutableList<PostEntity> = mutableListOf()

            posts.forEach {
                val postEntity = PostEntity()
                postEntity.id = it.id
                postEntity.title = it.title
                postEntity.description = it.description
                postEntity.userId = it.userId
                postEntities.add(postEntity)
            }

            postDaoContract.insertPosts(posts = postEntities.toTypedArray())
        }

        return LivePagedListBuilder(postDaoContract.queryAllPosts(), 20).build()
    }
}