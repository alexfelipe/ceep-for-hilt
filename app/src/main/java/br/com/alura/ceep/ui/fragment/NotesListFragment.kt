package br.com.alura.ceep.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import br.com.alura.ceep.databinding.FragmentNotesListBinding
import br.com.alura.ceep.ui.recyclerview.adapter.NotesListAdapter
import br.com.alura.ceep.ui.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class NotesListFragment : Fragment() {

    private var _binding: FragmentNotesListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteViewModel by viewModels()

    private val testViewModel: TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentNotesListBinding.inflate(
        inflater,
        container,
        false
    ).let {
        _binding = it
        it.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("NotesListFragment", "onViewCreated: $testViewModel")
        configureAdapter()
    }

    private fun configureAdapter() {
        NotesListAdapter(requireContext()).let { adapter ->
            binding.fragmentNotesListRecyclerview.adapter = adapter
            lifecycleScope.launchWhenResumed {
                viewModel.findAll().collect(adapter::update)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

@HiltViewModel
class TestViewModel @Inject constructor() : ViewModel()