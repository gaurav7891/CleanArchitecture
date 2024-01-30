package com.nativeworks.cleanarchpractise.framework

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nativeworks.core.data.Note
import com.nativeworks.core.repository.NoteRepository
import com.nativeworks.core.usecase.AddNote
import com.nativeworks.core.usecase.GetAllNotes
import com.nativeworks.core.usecase.GetNote
import com.nativeworks.core.usecase.RemoveNote
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(@ApplicationContext context: Context) : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val repository = NoteRepository(RoomNoteDataSource(context))
    /* val useCases = UseCases(
         AddNote(repository),
         GetAllNotes(repository),
         GetNote(repository),
         RemoveNote(repository),
     )*/

    @Inject
    lateinit var useCases: UseCases

    val saved = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note?>()

    fun getNote(id: Long) {
        coroutineScope.launch {
            currentNote.postValue(useCases.getNote(id))
        }
    }

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }

    fun deleteNote(note: Note) {
        coroutineScope.launch {
            useCases.removeNote(note)
            saved.postValue(true)
        }
    }
}