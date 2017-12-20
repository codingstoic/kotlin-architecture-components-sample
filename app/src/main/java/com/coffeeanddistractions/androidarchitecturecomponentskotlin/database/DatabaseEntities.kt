package com.coffeeanddistractions.androidarchitecturecomponentskotlin.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/*
 * Created by Abdu on 12/20/2017.
 */

@Entity(tableName = "users")
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name: String = "Default name"
    var email: String= "default@email.com"
}