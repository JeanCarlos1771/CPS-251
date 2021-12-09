package com.example.final_assignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Person::class)], version = 1)
abstract class PersonDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object{
        private var INSTANCE: PersonDatabase? = null

        internal fun getDatabase(context: Context): PersonDatabase? {
            if (INSTANCE == null){
                synchronized(PersonDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder<PersonDatabase>(context.applicationContext,PersonDatabase::class.java,"person_Database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}