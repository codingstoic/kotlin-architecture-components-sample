package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R

class CreatePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
    }
}
