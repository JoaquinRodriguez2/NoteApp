package com.example.noteapp.domain

import com.example.noteapp.data.NotesRepository
import com.example.noteapp.domain.model.NoteDetails
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val repository: NotesRepository
) {


    suspend fun getNotes():List<NoteDetails>{
        return repository.getNotesListFromDatabase()
    }


}