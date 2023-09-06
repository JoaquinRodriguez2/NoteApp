package com.example.watcht.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp.domain.model.NoteDetails


@Entity(tableName = "notes_table")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String?,

    )

fun NoteDetails.toDatabaseEntity() =
    NotesEntity(
        id = id,
        title = title,
        content = content,

    )