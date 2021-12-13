package com.example.iseprototype.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.iseprototype.PrescribedDrug
import com.example.iseprototype.Substitute

@Database(entities = [PrescribedDrug::class, Substitute::class], version = 1)
abstract class Database : RoomDatabase() {

}