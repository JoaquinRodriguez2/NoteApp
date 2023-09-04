package com.example.watcht.data.database.dao

import androidx.room.*
import com.example.watcht.data.database.entities.NotesEntity


@Dao
interface NotesDao {


    @Query("SELECT * FROM notes_table")
    suspend fun getAllNotes():List<NotesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:NotesEntity)
    @Delete
    suspend fun deleteNote(note: NotesEntity)
}