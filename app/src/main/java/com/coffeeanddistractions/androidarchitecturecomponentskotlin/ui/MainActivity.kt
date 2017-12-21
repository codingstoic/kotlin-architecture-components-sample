package com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.R
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.application.ApplicationClass
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.database.UserEntity
import com.coffeeanddistractions.androidarchitecturecomponentskotlin.ui.viewModels.UserViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val appClass = application as ApplicationClass

        fab.setOnClickListener { _ ->
            launch(CommonPool) {
                val newUser  = UserEntity()
                newUser.email = "arslan@email.com"
                newUser.name = "Arslan tech387"

                appClass.getAppDatabase().userDao().insertUser(newUser)
            }
        }

        userViewModel.getAllUsers().observe(this, Observer<Array<UserEntity>> {
            hello_text_view.text = "number of users ${it?.size}"
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
