package com.nativeworks.core.usecase

import com.nativeworks.core.data.Note
import com.nativeworks.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.removeNote(note)
}