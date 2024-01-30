package com.nativeworks.core.usecase

import com.nativeworks.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id:Long)= noteRepository.getNote(id)
}