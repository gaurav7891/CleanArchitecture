package com.nativeworks.cleanarchpractise.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nativeworks.cleanarchpractise.databinding.ItemNoteBinding
import com.nativeworks.core.data.Note
import java.text.SimpleDateFormat
import java.util.Date

class NotesListAdapter(private var notes: ArrayList<Note>, val action: ListAction) :
    RecyclerView.Adapter<NotesListAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            with(binding) {
                title.text = note.title
                content.text = note.content
                val sdf = SimpleDateFormat("MMM dd, HH:mm:ss")
                val resultDate = Date(note.updateTime)
                date.text = "Last updated: ${sdf.format(resultDate)}"
                noteLayout.setOnClickListener {
                    action.onClick(note.id)
                }
                wordCount.text = "Words: "+note.wordCount.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.bind(currentNote)
    }

    fun updateNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }
}