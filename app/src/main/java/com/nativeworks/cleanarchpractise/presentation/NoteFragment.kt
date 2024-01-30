package com.nativeworks.cleanarchpractise.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.nativeworks.cleanarchpractise.R
import com.nativeworks.cleanarchpractise.databinding.FragmentNoteBinding
import com.nativeworks.cleanarchpractise.framework.NoteViewModel
import com.nativeworks.core.data.Note
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    private var currentNote = Note("", "", 0L, 0L)
    private val viewModel: NoteViewModel by viewModels()
    private var noteId = 0L

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.notes_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.deleteNote -> {
                if (requireContext() != null && noteId != 0L) {
                    AlertDialog.Builder(requireContext())
                        .setTitle("Delete Note")
                        .setMessage("Are you sure to delete this note?")
                        .setPositiveButton("YES") { dialogInterface, i ->
                            viewModel.deleteNote(currentNote)
                        }
                        .setNegativeButton("CANCEL") { dialogInterface, i ->
                        }
                        .create()
                        .show()
                }
            }
        }
        return true

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            noteId = NoteFragmentArgs.fromBundle(it).noteId
        }
        if (noteId != 0L) {
            viewModel.getNote(noteId)
        }
        binding.saveNote.setOnClickListener {
            if (binding.titleView.text.toString() != "" || binding.contentView.text.toString() != "") {
                val time = System.currentTimeMillis()
                currentNote.title = binding.titleView.text.toString()
                currentNote.content = binding.contentView.text.toString()
                currentNote.updateTime = time
                if (currentNote.id == 0L) {
                    currentNote.creationTime = time
                }
                viewModel.saveNote(currentNote)
            } else {
                Navigation.findNavController(it).popBackStack()
            }
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.saved.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(requireContext(), "Done", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(binding.titleView).popBackStack()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Something went wrong, please try again",
                    Toast.LENGTH_SHORT
                ).show()

            }
        })

        viewModel.currentNote.observe(viewLifecycleOwner, Observer { note ->
            note?.let {
                currentNote = it
                binding.titleView.setText(it.title, TextView.BufferType.EDITABLE)
                binding.contentView.setText(it.content, TextView.BufferType.EDITABLE)
            }
        })
    }

}