package com.example.final_assignment

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
class Person {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "perosnId")
    var id: Int = 0

    @ColumnInfo(name = "personName")
    var personName: String? = null
    var personNumber: String? = null

    constructor(){}

    constructor(id: Int,personName: String, personNumber: String){
        this.personName = personName
        this.personNumber = personNumber
    }
    constructor(personName: String,personNumber: String){
        this.personName = personName
        this.personNumber = personNumber
    }
}