package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.lists

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import kotlinx.android.synthetic.main.user_list_row.view.*

/*
 * Created by Abdu on 12/21/2017.
 */

class PostAdapter(private val onItemClickListener: PostsListOnItemClickListener) :
        PagedListAdapter<PostEntity, PostViewHolder>(diffCallback), PostsViewHolderItemClickListener {
    override fun itemSelected(position: Int) {
        onItemClickListener.itemSelected(position, getItem(position))
    }

    companion object {
        val diffCallback: DiffCallback<PostEntity> = object : DiffCallback<PostEntity>() {
            override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean =
                    oldItem == newItem

            override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean =
                    oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(holder: PostViewHolder?, position: Int) {
        val postEntity = getItem(position)
        if (postEntity != null && holder != null) {
            holder.titleTextView.text = postEntity.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.user_list_row, parent, false) as View
        return PostViewHolder(view, this)
    }
}

class PostViewHolder(view: View, val itemClickListener: PostsViewHolderItemClickListener) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
    override fun onClick(p0: View?) {
        itemClickListener.itemSelected(adapterPosition)
    }

    val rootView = view
    val titleTextView = view.user_list_row_name

    init {
        rootView.setOnClickListener(this)
    }
}

interface PostsViewHolderItemClickListener {
    fun itemSelected(position: Int)
}

interface PostsListOnItemClickListener {
    fun itemSelected(position: Int, item: PostEntity?)
}
