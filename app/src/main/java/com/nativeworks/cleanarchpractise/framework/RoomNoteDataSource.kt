package com.nativeworks.cleanarchpractise.framework

import android.content.Context
import com.nativeworks.cleanarchpractise.framework.db.DatabaseService
import com.nativeworks.cleanarchpractise.framework.db.NoteEntity
import com.nativeworks.core.data.Note
import com.nativeworks.core.repository.NoteDataSource

class RoomNoteDataSource(context: Context):NoteDataSource {

    private val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long)= noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}