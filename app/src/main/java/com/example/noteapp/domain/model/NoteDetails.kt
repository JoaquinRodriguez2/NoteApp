package com.example.noteapp.domain.model

import com.example.watcht.data.database.entities.NotesEntity

data class NoteDetails(
    val id: Int?,
    val title: String,
    val content : String?
)


fun NotesEntity.toDomain() = NoteDetails(id, title, content)


