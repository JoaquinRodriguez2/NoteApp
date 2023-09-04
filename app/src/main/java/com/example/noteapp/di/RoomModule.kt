package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.watcht.data.database.NotesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {


    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        NotesDataBase:: class.java, "notes_table"
    ).build()

    @Singleton
    @Provides
    fun provideMoviesDao(db:NotesDataBase) = db.getNoteDao()
}