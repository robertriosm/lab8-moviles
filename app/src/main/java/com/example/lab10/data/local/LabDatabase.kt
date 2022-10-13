package com.example.lab10.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab10.data.local.dao.CharacterDao
import com.example.lab10.data.local.model.Character

@Database(
    entities = [Character::class],
    version = 1
)
abstract class LabDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}