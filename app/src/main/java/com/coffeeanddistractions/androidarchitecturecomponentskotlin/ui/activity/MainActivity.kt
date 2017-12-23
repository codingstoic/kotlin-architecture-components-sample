package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.lists.PostAdapter
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.lists.PostsListOnItemClickListener
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.viewModels.PostsViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PostsListOnItemClickListener {
    override fun itemSelected(position: Int, item: PostEntity?) {
        if (item != null) {
            val viewSingleItemIntent = Intent(this, ViewSinglePostActivity::class.java)
            viewSingleItemIntent.putExtra("id", item.id)
            println("item title = ${item.title} id = ${item.id}")
            startActivity(viewSingleItemIntent)
        } else {
            // todo display error
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)
        val adapter = PostAdapter(onItemClickListener = this)
        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_users_recycler_view)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        postsViewModel.getAllPosts().observe(this, Observer<PagedList<PostEntity>> { list ->
            adapter.setList(list)
        })

        fab.setOnClickListener { _ ->
            val createPostIntent = Intent(this@MainActivity, CreatePostActivity::class.java)
            startActivity(createPostIntent)
        }
    }
}

