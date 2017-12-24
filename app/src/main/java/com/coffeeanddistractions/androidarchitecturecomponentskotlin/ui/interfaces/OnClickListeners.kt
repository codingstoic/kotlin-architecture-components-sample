package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.interfaces

import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.PostEntity

/*
 * Created by Abdu on 12/24/2017.
 */
interface ViewHolderItemClickListener {
    fun itemSelected(position: Int)
}

interface GenericListOnItemClickListener<in T> {
    fun itemSelected(position: Int, item: T?)
}
