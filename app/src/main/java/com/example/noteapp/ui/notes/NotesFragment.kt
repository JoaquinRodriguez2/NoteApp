package com.example.noteapp.ui.notes

import androidx.fragment.app.viewModels
import com.example.noteapp.ui.help.HelpViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.databinding.FragmentHelpBinding
import com.example.noteapp.databinding.FragmentNotesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding


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

    }

    companion object {
        fun newInstance() = NotesFragment()
    }
}