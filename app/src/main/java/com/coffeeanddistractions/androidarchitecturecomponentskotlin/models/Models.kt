package com.coffeeanddistractions.androidarchitecturecomponentskotlin.models

/*
 * Created by Abdu on 12/20/2017.
 */

data class User(val id: Long, val name: String, val email: String)
data class Post(val id: Long, val title: String, val description: String, val commentCount: Int ,val userId: String)
data class Comment(val id: Long, val text: String, val userId: Long)
