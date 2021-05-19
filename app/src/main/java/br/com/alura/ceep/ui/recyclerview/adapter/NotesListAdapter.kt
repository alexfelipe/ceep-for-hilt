package br.com.alura.ceep.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.R
import br.com.alura.ceep.databinding.ItemNoteBinding

import br.com.alura.ceep.model.Note
import coil.load

private const val DEFAULT_IMAGE = "https://picsum.photos/400"

class NotesListAdapter(
    private val context: Context,
    notes: List<Note> = emptyList()
) : RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {

    private val dataset = notes.toMutableList()

    class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Note) {
            binding.apply {
                itemNoteTitle.text = task.title
                itemNoteDescription.text = task.description
                itemNoteimageView.load(DEFAULT_IMAGE) {
                    placeholder(R.drawable.image_placeholder)
                    fallback(R.drawable.image_placeholder)
                    error(R.drawable.image_placeholder)
                }
            }
        }

    }

    fun update(notes: List<Note>) {
        dataset.clear()
        dataset.addAll(notes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        ItemNoteBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.bind(dataset[position])

    override fun getItemCount() = dataset.size

}