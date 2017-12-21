package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.lists

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserEntity

/*
 * Created by Abdu on 12/21/2017.
 */

class UserAdapter : PagedListAdapter<UserEntity, UserViewHolder>(diffCallback) {
    companion object {
        val diffCallback: DiffCallback<UserEntity> = object : DiffCallback<UserEntity>() {
            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean =
                    oldItem.name == newItem.name && oldItem.email == newItem.email

            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean =
                    oldItem.id == newItem.id

        }
    }

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        val user = getItem(position)
        if (user != null) {
            val userNameText = holder?.view?.findViewById<TextView>(R.id.user_list_row_name)
            userNameText?.text = user.name
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

class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view)
