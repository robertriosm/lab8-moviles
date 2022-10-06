package com.example.lab10.datasource.api

import androidx.room.*
import com.example.lab10.datasource.model.User

interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAllUsers() : List<User>

    @Insert
    suspend fun createUser(user: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll()

}