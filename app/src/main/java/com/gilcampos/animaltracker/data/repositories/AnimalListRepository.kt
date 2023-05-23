package com.gilcampos.animaltracker.data.repositories

import com.gilcampos.animaltracker.model.Animal

class AnimalListRepository(private val animalList: MutableList<Animal>) {
    fun getAnimals() = animalList

    fun addAnimals(item: Animal) = animalList.add(item)
}