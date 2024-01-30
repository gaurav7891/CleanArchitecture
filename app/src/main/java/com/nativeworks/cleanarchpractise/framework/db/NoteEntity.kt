package com.nativeworks.cleanarchpractise.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nativeworks.core.data.Note

@Entity(tableName = "note")
data class NoteEntity(
    val title: String,
    val content: String,
    @ColumnInfo("creation_date")
    val creationTime: Long,
    @ColumnInfo("update_time")
    val updateTime: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
) {
    companion object {
        fun fromNote(note: Note) = NoteEntity(
            note.title, note.content, note.creationTime, note.updateTime,note.id
        )
    }

    fun toNote() = Note(title, content, creationTime, updateTime, id)
}