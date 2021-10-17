package com.example.add_name_data

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var names = arrayListOf<String>()
    var nameList = ""

    fun storeNames(person: String){
        names.add(person.toString())
    }

}