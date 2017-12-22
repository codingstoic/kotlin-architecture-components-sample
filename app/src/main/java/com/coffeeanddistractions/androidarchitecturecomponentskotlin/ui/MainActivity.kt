package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.application.ApplicationClass
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.lists.PostAdapter
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.lists.UserAdapter
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.viewModels.PostsViewModel
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.viewModels.UserViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)
        val adapter = PostAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_users_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        postsViewModel.getAllPosts().observe(this, Observer<PagedList<PostEntity>> { list ->
            adapter.setList(list)
        })

        val appClass = application as ApplicationClass

        fab.setOnClickListener { _ ->
            launch(CommonPool) {
                val newPost  = PostEntity()
                newPost.title = "New post title 1"
                newPost.description = "This is a description for post named new post title 1"
                newPost.userId = 1
                newPost.commentCount = 0
                appClass.getAppDatabase().postDao().createPost(newPost)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
