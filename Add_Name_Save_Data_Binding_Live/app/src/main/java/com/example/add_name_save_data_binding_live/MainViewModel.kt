package com.example.add_name_save_data_binding_live

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var name : MutableLiveData<String> = MutableLiveData()
    var nameList : MutableLiveData<String> = MutableLiveData()
    var isEmpty = false

    init {
        nameList.value = "No names to Display"
    }

    fun storeNames(){

        name.let {
            if(!it.value.equals("")){
                if(!isEmpty){
                    nameList.value = ""
                    isEmpty = true
                }
                nameList.value += it.value?.toString()+"\n"
            }
        }


    }

}