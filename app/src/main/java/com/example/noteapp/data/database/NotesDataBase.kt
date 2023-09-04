package com.example.watcht.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.watcht.data.database.dao.NotesDao
import com.example.watcht.data.database.entities.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDataBase:RoomDatabase() {

    abstract fun getNoteDao(): NotesDao

}