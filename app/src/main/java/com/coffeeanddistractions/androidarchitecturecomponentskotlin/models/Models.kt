package com.coffeeanddistractions.androidarchitecturecomponentskotlin.models

/*
 * Created by Abdu on 12/20/2017.
 */

const val POST_ENTITY_ID_SERIALIZE_KEY = "post_id"
data class User(val id: Long, val name: String, val email: String)
data class Post(val id: Long, val title: String, val description: String, val commentCount: Int ,val userId: Long)
data class Comment(val id: Long, val body: String, val userId: Long, val postId: Long)
