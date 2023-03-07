package com.rpfcoding.androidroommigrationpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "users.db"
        ).addMigrations(UserDatabase.migration3To4)
            .build()

//        (1..10).forEach {
//            lifecycleScope.launch {
//                db.userDao.insertSchool(
//                    School(name = "School$it")
//                )
//            }
//        }

        lifecycleScope.launch {
            Log.d("USERS", db.userDao.getUsers().toString())
            Log.d("USERS", db.userDao.getSchools().toString())
        }
    }
}