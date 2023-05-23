package com.gilcampos.animaltracker.ui.tracker.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animaltracker.databinding.AnimalListItemBinding
import com.gilcampos.animaltracker.model.Animal

class AnimalListRecyclerAdapter(private val clickListener: (Animal) -> Unit) :
    RecyclerView.Adapter<AnimalListRecyclerViewHolder>() {

    private val animalList = ArrayList<Animal>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalListRecyclerViewHolder {
        val listItem = AnimalListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalListRecyclerViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: AnimalListRecyclerViewHolder, position: Int) {
        holder.bind(animalList[position], clickListener)
    }

    fun setList(listItems: List<Animal>) {
        animalList.clear()
        animalList.addAll(listItems)
    }
}