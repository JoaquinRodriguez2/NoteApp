package com.example.noteapp.domain

import com.example.noteapp.data.NotesRepository
import com.example.noteapp.domain.model.NoteDetails
import com.example.watcht.data.database.entities.toDatabaseEntity
import javax.inject.Inject

class DeleteNotesUseCase@Inject constructor(
    private val apiServices: NotesRepository,
) {


    suspend fun deleteMovie(movie: NoteDetails){
        apiServices.deleteNoteFromDatabase(movie.toDatabaseEntity())
    }


}