package com.gilcampos.animaltracker.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gilcampos.animaltracker.data.animals
import com.gilcampos.animaltracker.data.repositories.AnimalListRepository
import com.gilcampos.animaltracker.model.Animal

class AnimalTrackerViewModel : ViewModel() {

    private val repository = AnimalListRepository(animals)
    var name = MutableLiveData<String>("")
    var species = MutableLiveData<String>("")
    var habitat = MutableLiveData<String>("")
    val status = MutableLiveData("")

    fun getAnimals() = repository.getAnimals()

    fun addAnimals(animal: Animal) = repository.addAnimals(animal)

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            species.value.isNullOrEmpty() -> return false
            habitat.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        species.value = ""
        habitat.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun createAnimal() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }
        val item = Animal(name.value!!, species.value!!, habitat.value!!)
        addAnimals(item)
        clearData()
        status.value = ANIMAL_CREATED
    }

    fun selectedAnimal(item: Animal) {
        name.value = item.name
        species.value = item.species
        habitat.value = item.habitat
    }

    companion object {
        const val ANIMAL_CREATED = "Animal Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }
}