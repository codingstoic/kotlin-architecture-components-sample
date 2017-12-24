package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.singlePost

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.CommentEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.POST_ENTITY_ID_SERIALIZE_KEY
import kotlinx.android.synthetic.main.activity_view_single_post.*

class SinglePostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_single_post)

        val postId = intent?.getLongExtra(POST_ENTITY_ID_SERIALIZE_KEY, 0)

        if (postId != null) {
            val singlePostViewModel = ViewModelProviders.of(this).get(SinglePostViewModel::class.java)
            val recyclerView = activitySinglePostCommentsRecyclerView
            val adapter = CommentAdapter()

            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

            singlePostViewModel.getPostById(postId)?.observe(this, Observer<PostEntity> { entity ->
                activitySinglePostTitleTextView.text = entity?.title
            })

            singlePostViewModel.getCommentsForPostId(postId)?.observe(this, Observer<PagedList<CommentEntity>> { list -> adapter.setList(list) })

        } else {
            activitySinglePostTitleTextView.text = getString(R.string.activity_single_post_not_found_message)
        }
    }
}
