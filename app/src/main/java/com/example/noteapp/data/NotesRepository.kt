package com.example.noteapp.data

import com.example.noteapp.domain.model.NoteDetails
import com.example.noteapp.domain.model.toDomain
import com.example.watcht.data.database.dao.NotesDao
import com.example.watcht.data.database.entities.NotesEntity
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class NotesRepository @Inject constructor(
    private val notesDao: NotesDao

) {

    suspend fun deleteNoteFromDatabase(item : NotesEntity){

        notesDao.deleteNote(item)


    }

    suspend fun getNotesListFromDatabase():List<NoteDetails>{

        val response = notesDao.getAllNotes()
        return response.map { it.toDomain() }

    }


    suspend fun insertNoteToDatabase(item : NotesEntity){

        notesDao.insertNote(item)

    }

}