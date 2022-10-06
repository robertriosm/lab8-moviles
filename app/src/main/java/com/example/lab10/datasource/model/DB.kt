package com.example.lab10.datasource.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab10.datasource.api.UserDao

@Database(entities = [UserDao::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract fun userDao() : UserDao


}