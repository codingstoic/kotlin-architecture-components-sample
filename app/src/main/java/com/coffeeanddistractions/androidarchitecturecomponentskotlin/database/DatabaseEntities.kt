package com.coffeeanddistractions.androidarchitecturecomponentskotlin.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/*
 * Created by Abdu on 12/20/2017.
 */

@Entity(tableName = "users")
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name: String = "Default name"
    var email: String = "default@email.com"
}

@Entity(tableName = "posts",
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = UserEntity::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("userId")
                )
        )
)
class PostEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var title: String = "Default Title"
    var description: String = "Default description"
    var commentCount: Int = 0
    var userId: Int = 0
}

@Entity(tableName = "comments",
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = UserEntity::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("userId")
                ),
                ForeignKey(
                        entity = PostEntity::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("postId")
                )
        )
)
class CommentEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var body: String = "Default Title"
    var userId: Int = 0
    var postId: Int = 0
}
