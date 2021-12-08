package com.example.final_assignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Person::class)], version = 1)
abstract class PersonRoomDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object{

        private var INSTANCE: PersonRoomDatabase? = null

        internal fun getDatabase(context: Context): PersonRoomDatabase? {
            if (INSTANCE == null){
                synchronized(PersonRoomDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder<PersonRoomDatabase>(context.applicationContext,PersonRoomDatabase::class.java,"contacts_database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}