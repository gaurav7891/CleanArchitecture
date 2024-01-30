package com.nativeworks.cleanarchpractise.framework.di

import android.app.Application
import android.content.Context
import com.nativeworks.cleanarchpractise.framework.RoomNoteDataSource
import com.nativeworks.core.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    fun providesRepository(@ApplicationContext context: Context) =
        NoteRepository(RoomNoteDataSource(context))

}