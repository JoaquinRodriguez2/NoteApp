package com.example.noteapp.ui.notes

import androidx.fragment.app.viewModels
import com.example.noteapp.ui.help.HelpViewModel
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.databinding.FragmentHelpBinding
import com.example.noteapp.databinding.FragmentNotesBinding
import com.example.noteapp.domain.model.NoteDetails
import com.example.noteapp.ui.notes.adapter.NotesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding

    @Inject
    lateinit var notesAdapter: NotesAdapter

    private val viewModel by viewModels<NotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewModel.getNotes()

        viewModel.dataSaved.observe(viewLifecycleOwner) { data ->

            when (data) {
                is SavedNotes.Loading -> {}
                is SavedNotes.Success -> {
                    notesAdapter.differ.submitList(data.response)
                    binding.recViewNotes.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = notesAdapter
                    }
                    binding.addNote.setOnClickListener {
                        viewModel.createEmptyNote()
                        viewModel.getNotes()

                    }
                    notesAdapter.setOnDeleteClickListener { viewModel.deleteNote(it)
                                                                        viewModel.getNotes()
                    }
                    notesAdapter.setOnEditClickListener { Log.i("Joaking","Edit ${it.id}") }

                }
            }

        }


    }

    companion object {
        fun newInstance() = NotesFragment()
    }
}