package com.example.noteapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.ui.help.HelpFragment
import com.example.noteapp.ui.notes.NotesFragment
import com.example.noteapp.ui.reminders.RemindersFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(NotesFragment())

        binding.bottomNavBar.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.help -> replaceFragment(HelpFragment())
                R.id.notes -> replaceFragment(NotesFragment())
                R.id.reminders -> replaceFragment(RemindersFragment())

                else -> {


                }

            }

            true

        }


    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()


    }

}




