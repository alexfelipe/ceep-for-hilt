package br.com.alura.ceep.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.databinding.ItemTaskBinding
import br.com.alura.ceep.model.Task
import coil.load

class TasksListAdapter(
    private val context: Context,
    val tasks: List<Task>
) : RecyclerView.Adapter<TasksListAdapter.ViewHolder>() {

    private val dataset = tasks.toMutableList()

    class ViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task) {
            binding.apply {
                itemTaskTitle.text = task.title
                itemTaskDescription.text = task.description
                itemTaskimageView.load("https://picsum.photos/400")
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        ItemTaskBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.bind(tasks[position])

    override fun getItemCount() = dataset.size

}
