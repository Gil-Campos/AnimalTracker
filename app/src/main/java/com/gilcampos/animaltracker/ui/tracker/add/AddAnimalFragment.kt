package com.gilcampos.animaltracker.ui.tracker.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.animaltracker.R
import com.example.animaltracker.databinding.FragmentAddAnimalBinding
import com.gilcampos.animaltracker.ui.AnimalTrackerViewModel

class AddAnimalFragment : Fragment() {

    private var _binding: FragmentAddAnimalBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AnimalTrackerViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        todoStatus()
    }

    private fun setViewModel() {
        binding.viewModel = viewModel
    }

    private fun todoStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(AnimalTrackerViewModel.WRONG_INFORMATION) -> {
                    viewModel.clearStatus()
                }

                status.equals(AnimalTrackerViewModel.ANIMAL_CREATED) -> {
                    viewModel.clearStatus()
                    findNavController().navigate(R.id.action_addAnimalFragment_to_animalListFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}