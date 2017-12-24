package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.singlePost

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.CommentEntity
import kotlinx.android.synthetic.main.comment_list_row.view.*

/*
 * Created by Abdu on 12/24/2017.
 */

class CommentAdapter : PagedListAdapter<CommentEntity, CommentViewHolder>(diffCallback){
    companion object {
        val diffCallback: DiffCallback<CommentEntity> = object : DiffCallback<CommentEntity>() {
            override fun areContentsTheSame(oldItem: CommentEntity, newItem: CommentEntity): Boolean =
                    oldItem == newItem

            override fun areItemsTheSame(oldItem: CommentEntity, newItem: CommentEntity): Boolean =
                    oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(holder: CommentViewHolder?, position: Int) {
        val commentEntity = getItem(position)
        if (commentEntity != null && holder != null) {
            holder.commentBodyTextView.text = commentEntity.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.comment_list_row, parent, false) as View
        return CommentViewHolder(view)
    }
}

class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val rootView = view
    val commentBodyTextView = view.comment_list_comment_body
}

