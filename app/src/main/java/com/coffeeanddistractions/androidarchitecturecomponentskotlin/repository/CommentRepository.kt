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
        return LivePagedListBuilder(commentDaoContract.getCommentsForPostId(id), 20).build()
    }

}