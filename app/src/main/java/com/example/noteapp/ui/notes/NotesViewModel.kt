package com.example.noteapp.ui.notes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.CreateNoteUseCase
import com.example.noteapp.domain.DeleteNotesUseCase
import com.example.noteapp.domain.GetAllNotesUseCase
import com.example.noteapp.domain.model.NoteDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class SavedNotes{
    object Loading : SavedNotes()
    data class Success(val response: List<NoteDetails>) : SavedNotes()
}


@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotesListDataBaseUseCase: GetAllNotesUseCase,
    private val createNoteUseCase : CreateNoteUseCase,
    private val deleteNotesUseCase : DeleteNotesUseCase
) : ViewModel() {

    private val _dataSaved = MutableLiveData<SavedNotes>()
    val dataSaved: LiveData<SavedNotes> = _dataSaved

    fun createEmptyNote(){
        viewModelScope.launch {
            val emptyNote: NoteDetails = NoteDetails(id = null,title = "title", content = "Empty")
            createNoteUseCase.saveNote(emptyNote)
        }
    }

    fun deleteNote(note: NoteDetails){
        viewModelScope.launch {
            deleteNotesUseCase.deleteMovie(note)
        }
    }
    fun getNotes(){
        _dataSaved.postValue(SavedNotes.Loading)
        viewModelScope.launch{
            Log.i("JoakingData","DataReload")
            val savedData = getNotesListDataBaseUseCase.getNotes()
            _dataSaved.postValue(SavedNotes.Success(savedData))
        }
    }



}