package com.nativeworks.cleanarchpractise.framework

import com.nativeworks.core.usecase.AddNote
import com.nativeworks.core.usecase.GetAllNotes
import com.nativeworks.core.usecase.GetNote
import com.nativeworks.core.usecase.GetWordCount
import com.nativeworks.core.usecase.RemoveNote

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val wordCount: GetWordCount
)