package com.nativeworks.cleanarchpractise.framework.di

import com.nativeworks.cleanarchpractise.framework.UseCases
import com.nativeworks.core.repository.NoteRepository
import com.nativeworks.core.usecase.AddNote
import com.nativeworks.core.usecase.GetAllNotes
import com.nativeworks.core.usecase.GetNote
import com.nativeworks.core.usecase.GetWordCount
import com.nativeworks.core.usecase.RemoveNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun providesUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )

}