package com.example.noteapp.ui.help

import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.viewModels
import com.example.noteapp.ui.help.HelpViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentHelpBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HelpFragment : Fragment() {

    private lateinit var binding: FragmentHelpBinding


    private val viewModel by viewModels<HelpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance() = HelpFragment()
    }
}