package com.example.final_assignment

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class PersonRepository(application: Application) {

    val searchResults =  MutableLiveData<List<Person>>()
    private var personDao: PersonDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Person>>?

    init {
        val db: PersonDatabase? = PersonDatabase.getDatabase(application)
        personDao = db?.personDao()
        allContacts = personDao?.getAllContacts()
    }

    fun insertPerson(newPerson: Person){
        coroutineScope.launch(Dispatchers.IO){
            asyncInsert(newPerson)
        }
    }

    private suspend fun asyncInsert(person: Person){
        personDao?.insertPerson(person)
    }

    fun deletePerson(name:String){
        coroutineScope.launch(Dispatchers.IO){
            asyincDelete(name)
        }
    }

    private suspend fun asyincDelete(name: String){
        personDao?.deletePerson(name)
    }

    fun ascending(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncAsc().await()
        }
    }

    private suspend fun asyncAsc(): Deferred<List<Person>?> = coroutineScope.async(Dispatchers.IO){
        return@async personDao?.getAllContactsAsc()
    }

    fun descending(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncDesc().await()
        }
    }

    private suspend fun asyncDesc(): Deferred<List<Person>?> = coroutineScope.async(Dispatchers.IO){
        return@async personDao?.getAllContactsDesc()
    }

    fun findPerson(name: String){
        coroutineScope.async(Dispatchers.Main){
            searchResults.value = asyncFind(name).await()
        }
    }

    private suspend fun  asyncFind(name: String): Deferred<List<Person>?> = coroutineScope.async(Dispatchers.IO){
        return@async personDao?.findPerson(name)
    }

}