package com.gilcampos.animaltracker.ui.tracker.display

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.animaltracker.R
import com.example.animaltracker.databinding.FragmentAnimalDetailsBinding
import com.gilcampos.animaltracker.ui.AnimalTrackerViewModel

class AnimalDetailsFragment : Fragment() {

    private var _binding: FragmentAnimalDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AnimalTrackerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}