package com.coffeeanddistractions.androidarchitecturecomponentskotlin.services

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.Post

/*
 * Created by Abdu on 12/22/2017.
 */

interface PostServiceDefinition{
    suspend fun getPost(postId: Long): Post
    suspend fun getAllPosts(): Array<Post>
    suspend fun updatePost(postId: Long, post: Post)
}