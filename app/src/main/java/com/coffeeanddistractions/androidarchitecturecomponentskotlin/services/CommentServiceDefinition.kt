package com.coffeeanddistractions.androidarchitecturecomponentskotlin.services

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.Comment

/*
 * Created by Abdu on 12/24/2017.
 */

interface CommentServiceDefinition{
    suspend fun getAllCommentsForPost(postId: Long): Array<Comment>
}