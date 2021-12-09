package com.example.final_assignment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : PersonRepository = PersonRepository(application)
    private val contacts: LiveData<List<Person>>?
    private val searchResults: MutableLiveData<List<Person>>

    init {
        contacts = repository.allContacts
        searchResults = repository.searchResults
    }

    fun insertContact(person: Person){
        repository.insertPerson(person)
    }

    fun findContact(name: String){
        repository.findPerson(name)
    }

    fun deleteContact(id: Int){
        repository.deletePerson(id)
    }

    fun ascendingOrder(){
        repository.ascending()
    }

    fun descendingOrder(){
        repository.descending()
    }

    fun getSearchResults(): MutableLiveData<List<Person>>{
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Person>>?{
        return contacts
    }
}