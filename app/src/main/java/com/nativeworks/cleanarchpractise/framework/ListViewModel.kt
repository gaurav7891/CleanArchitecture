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
class ListViewModel @Inject constructor(@ApplicationContext context: Context) :
    ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val repository = NoteRepository(RoomNoteDataSource(context))

    /*private val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
    )*/
    @Inject
    lateinit var useCases: UseCases

    val notes = MutableLiveData<List<Note>>()
    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach{it.wordCount = useCases.wordCount.invoke(it)}
            notes.postValue(noteList)
        }
    }
}