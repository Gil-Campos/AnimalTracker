package com.gilcampos.animaltracker.ui.tracker.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animaltracker.R
import com.example.animaltracker.databinding.FragmentAnimalListBinding
import com.gilcampos.animaltracker.model.Animal
import com.gilcampos.animaltracker.ui.AnimalTrackerViewModel

class AnimalListFragment : Fragment() {

    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AnimalTrackerViewModel by activityViewModels()
    private lateinit var recyclerAdapter: AnimalListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView(view)
        clickListeners()
    }

    private fun setUpRecyclerView(view: View) {
        recyclerAdapter = AnimalListRecyclerAdapter {
            listAnimalINfo(it)
        }
        binding.animalListRecyclerview.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = recyclerAdapter
        }
        displayAnimals()
    }

    private fun displayAnimals() {
        recyclerAdapter.setList(viewModel.getAnimals())
        recyclerAdapter.notifyDataSetChanged()
    }


    private fun listAnimalINfo(animal: Animal) {
        viewModel.selectedAnimal(animal)
        findNavController().navigate(R.id.action_animalListFragment_to_animalDetailsFragment)
    }

    private fun clickListeners() {
        binding.addNewAnimalFloatinButton.setOnClickListener {
            viewModel.clearData()
            findNavController().navigate(R.id.action_animalListFragment_to_addAnimalFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}