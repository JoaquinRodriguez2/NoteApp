package com.example.noteapp.domain

import com.example.noteapp.data.NotesRepository
import com.example.noteapp.domain.model.NoteDetails
import com.example.watcht.data.database.entities.toDatabaseEntity
import javax.inject.Inject

class CreateNoteUseCase@Inject constructor(
    private val repository: NotesRepository
) {

    suspend fun saveNote(movie: NoteDetails){
        repository.insertNoteToDatabase(movie.toDatabaseEntity())
    }

}