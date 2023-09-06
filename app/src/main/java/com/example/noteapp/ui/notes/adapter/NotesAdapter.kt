package com.example.noteapp.ui.notes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import javax.inject.Inject
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.ItemNoteBinding
import com.example.noteapp.domain.model.NoteDetails

class NotesAdapter  @Inject() constructor() : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    private lateinit var binding: ItemNoteBinding
    private lateinit var context: Context
    private var onDelete: ((NoteDetails) -> Unit)? = null
    private var onEdit: ((NoteDetails) -> Unit)? = null

    fun setOnDeleteClickListener(listener: (NoteDetails) -> Unit) {
        onDelete = listener
    }
    fun setOnEditClickListener(listener: (NoteDetails) -> Unit) {
        onEdit = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemNoteBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun getItemViewType(position: Int): Int = position
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: NoteDetails) {

            binding.apply {
                tvTitle.text = item.title
                tvContent.text = item.content
                btnDelete.setOnClickListener { onDelete?.invoke(item) }
                btnEdit.setOnClickListener { onEdit?.invoke(item) }
            }
        }
    }


   //diff utils
    private val differCallback = object : DiffUtil.ItemCallback<NoteDetails>() {
        override fun areItemsTheSame(oldItem: NoteDetails, newItem: NoteDetails): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteDetails, newItem: NoteDetails): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}