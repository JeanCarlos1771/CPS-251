package com.example.final_assignment

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {

    @Insert
    fun insertPerson(person: Person)

    @Query("SELECT * FROM Contacts WHERE personName LIKE '%'|| :name || '%'")
    fun findPerson(name: String): List<Person>

    @Query("DELETE FROM Contacts WHERE personName = :name")
    fun deletePerson(name: String)

    @Query("SELECT * FROM Contacts")
    fun getAllContacts(): LiveData<List<Person>>

    @Query("SELECT * FROM Contacts ORDER BY personName ASC")
    fun getAllContactsAsc(): List<Person>

    @Query("SELECT * FROM Contacts ORDER BY personName DESC")
    fun getAllContactsDesc(): List<Person>
}