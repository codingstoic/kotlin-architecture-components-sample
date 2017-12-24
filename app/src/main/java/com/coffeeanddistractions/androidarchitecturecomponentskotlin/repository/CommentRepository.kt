package com.coffeeanddistractions.androidarchitecturecomponentskotlin.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.CommentDaoContract
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.CommentEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.services.ServiceClientDefinition
import kotlinx.coroutines.experimental.launch

/*
 * Created by Abdu on 12/24/2017.
 */

class CommentRepository(val serviceClientImplementation: ServiceClientDefinition,
                     val commentDaoContract: CommentDaoContract){

    fun getCommentsForPostId(id: Long): LiveData<PagedList<CommentEntity>> {
        launch {
            val comments = serviceClientImplementation.getAllCommentsForPost(id)
            val commentEntities: MutableList<CommentEntity> = mutableListOf()

            comments.forEach {
                val postEntity = CommentEntity()
                postEntity.id = it.id
                postEntity.body = it.body
                postEntity.userId = it.userId
                postEntity.postId = it.postId
                commentEntities.add(postEntity)
            }

            commentDaoContract.insertComments(comments = commentEntities.toTypedArray())
        }

        return LivePagedListBuilder(commentDaoContract.getCommentsForPostId(id), 20).build()
    }

}