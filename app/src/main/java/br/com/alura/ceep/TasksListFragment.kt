package br.com.alura.ceep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.alura.ceep.databinding.FragmentTasksListBinding
import br.com.alura.ceep.model.Task
import br.com.alura.ceep.ui.recyclerview.adapter.TasksListAdapter

class TasksListFragment : Fragment() {

    private var _binding: FragmentTasksListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentTasksListBinding.inflate(
        inflater,
        container,
        false
    ).let {
        _binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentTasksListRecyclerview.adapter =
            TasksListAdapter(
                requireContext(), listOf(
                    Task(
                        title = "test title",
                        description = "test desc"
                    ),
                    Task(
                        title = "test title",
                        description = "test desc"
                    ),
                )
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}