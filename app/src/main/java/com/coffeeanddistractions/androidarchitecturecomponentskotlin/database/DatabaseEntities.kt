package com.coffeeanddistractions.androidarchitecturecomponentskotlin.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/*
 * Created by Abdu on 12/20/2017.
 */


@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = "Default name",
    var email: String = "default@email.com"
)

@Entity(tableName = "posts")
data class PostEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var title: String = "Default Title",
    var description: String = "Default description",
    var commentCount: Int = 0,
    var userId: Long = 0
)

@Entity(tableName = "comments")
data class CommentEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var body: String = "Default Title",
    var userId: Long = 0,
    var postId: Long = 0
)
