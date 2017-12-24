package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.postList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.POST_ENTITY_ID_SERIALIZE_KEY
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.activity.CreatePostActivity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.interfaces.GenericListOnItemClickListener
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.singlePost.ViewSinglePostActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), GenericListOnItemClickListener<PostEntity> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)
        val adapter = PostAdapter(onItemClickListener = this)
        val recyclerView = activity_main_users_recycler_view

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

    override fun itemSelected(position: Int, item: PostEntity?) {
        if (item != null) {
            val viewSingleItemIntent = Intent(this, ViewSinglePostActivity::class.java)
            viewSingleItemIntent.putExtra(POST_ENTITY_ID_SERIALIZE_KEY, item.id)
            startActivity(viewSingleItemIntent)
        } else {
            Toast.makeText(this, "Could not open selected post", Toast.LENGTH_SHORT).show()
        }
    }
}

