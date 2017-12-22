package com.coffeeanddistractions.androidarchitecturecomponentskotlin.services

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

    suspend override fun getPost(postId: Long): Post {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    suspend override fun getAllPosts(): Array<Post> {
        val posts = arrayOf(
                Post(
                        id = 1,
                        title = "Default title ${randomGenerator.nextInt(100)}",
                        commentCount = 0,
                        userId = 1,
                        description = "default Description ${randomGenerator.nextInt(100)}")
        )
        delay(5, TimeUnit.SECONDS)
        return posts
    }

    suspend override fun updatePost(postId: Long, post: Post) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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