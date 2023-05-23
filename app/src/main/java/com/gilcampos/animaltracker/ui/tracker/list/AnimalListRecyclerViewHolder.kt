package com.gilcampos.animaltracker.ui.tracker.list

import androidx.recyclerview.widget.RecyclerView
import com.example.animaltracker.databinding.AnimalListItemBinding
import com.gilcampos.animaltracker.model.Animal

class AnimalListRecyclerViewHolder(private val binding: AnimalListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(animalItem: Animal, clickListener: (Animal) -> Unit) {
        binding.animalName.text = animalItem.name
        binding.animalSpecies.text = animalItem.species
        binding.animalHabitat.text = animalItem.habitat

        binding.root.setOnClickListener {
            clickListener(animalItem)
        }
    }
}