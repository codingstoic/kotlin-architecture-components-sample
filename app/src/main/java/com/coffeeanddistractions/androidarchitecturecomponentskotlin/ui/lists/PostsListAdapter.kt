package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.lists

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.models.Post

/*
 * Created by Abdu on 12/21/2017.
 */

class PostAdapter : PagedListAdapter<PostEntity, UserViewHolder>(diffCallback) {
    companion object {
        val diffCallback: DiffCallback<PostEntity> = object : DiffCallback<PostEntity>() {
            override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean =
                    oldItem == newItem

            override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean =
                    oldItem.id == newItem.id

        }
    }

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        val postEntity = getItem(position)
        if (postEntity != null) {
            val postTitle = holder?.view?.findViewById<TextView>(R.id.user_list_row_name)
            postTitle?.text = postEntity.title
        } else {
            holder?.view?.findViewById<TextView>(R.id.user_list_row_name)?.text = ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.user_list_row, parent, false) as View
        return UserViewHolder(view)
    }

}

class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view)
