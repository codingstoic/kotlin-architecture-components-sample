package com.coffeeanddistractions.androidarchitecturecomponentskotlin.services

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.Comment
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.Post
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.User
import kotlinx.coroutines.experimental.delay
import java.util.*
import java.util.concurrent.TimeUnit

/*
 * Created by Abdu on 12/20/2017.
 */

class ServiceClientImplementation : ServiceClientDefinition {
    private val randomGenerator = Random()

    suspend override fun getAllCommentsForPost(postId: Long): Array<Comment> {
        delay(time = 2, unit = TimeUnit.SECONDS)

        val comments = mutableListOf<Comment>()
        IntRange(1, 10).forEach {
            comments.add(Comment(
                    id = it.toLong(),
                    body = "Default body ${randomGenerator.nextInt(100)}",
                    postId = postId,
                    userId = 1))
        }

        return comments.toTypedArray()
    }

    suspend override fun getPost(postId: Long): Post {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun getAllPosts(): Array<Post> {
        delay(time = 2, unit = TimeUnit.SECONDS)

        val posts = mutableListOf<Post>()
        IntRange(1, 10).forEach {
            posts.add(Post(
                    id = it.toLong(),
                    title = "Default title ${randomGenerator.nextInt(100)}",
                    commentCount = 0,
                    userId = 1,
                    description = "default Description ${randomGenerator.nextInt(100)}"))
        }

        return posts.toTypedArray()
    }

    suspend override fun getAllUsers(): Array<User> {
        val users = arrayOf(User(name = "abdu", email = "adil@email.com", id = 1))
        delay(5, TimeUnit.SECONDS)
        return users
    }

    suspend override fun getUser(userId: Long): User {
        val user = User(name = "abdu", email = "adil@email.com", id = 1)
        delay(3, TimeUnit.SECONDS)
        return user
    }

    suspend override fun updateUser(userId: Long, user: User) {
        // todo after retrofit
    }
}