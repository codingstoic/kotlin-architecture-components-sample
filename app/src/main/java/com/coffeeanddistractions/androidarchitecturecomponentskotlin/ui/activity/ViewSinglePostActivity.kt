package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R

class ViewSinglePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_single_post)
    }
}
