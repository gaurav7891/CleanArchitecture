package com.nativeworks.core.usecase

import com.nativeworks.core.data.Note
import com.nativeworks.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note:Note) = noteRepository.addNote(note)
}