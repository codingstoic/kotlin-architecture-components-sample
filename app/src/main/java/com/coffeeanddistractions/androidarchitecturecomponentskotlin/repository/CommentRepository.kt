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
                     val commentDaoContract: CommentDaoContract): CommentRepositoryContract{

    override fun getCommentsForPostId(id: Long): LiveData<PagedList<CommentEntity>> {
        launch {
            val comments = serviceClientImplementation.getAllCommentsForPost(id)
            val commentEntities: MutableList<CommentEntity> = mutableListOf()

            comments.forEach {
                val commentEntity = CommentEntity()
                commentEntity.id = it.id
                commentEntity.body = it.body
                commentEntity.userId = it.userId
                commentEntity.postId = id
                commentEntities.add(commentEntity)
            }

            commentDaoContract.insertComments(comments = commentEntities.toTypedArray())
        }

        return LivePagedListBuilder(commentDaoContract.getCommentsForPostId(id), 20).build()
    }

}