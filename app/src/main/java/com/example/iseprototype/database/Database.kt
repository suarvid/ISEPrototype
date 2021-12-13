package com.example.iseprototype.database

import androidx.room.*
import androidx.room.Database
import com.example.iseprototype.PrescribedDrug
import com.example.iseprototype.Substitute

@Database(entities = [PrescribedDrug::class, Substitute::class], version = 1)
@TypeConverters(PrescribedDrugTypeConverters::class) // Not clear if this is how multiple converters are issued
abstract class Database : RoomDatabase() {
    abstract fun dao(): DAO
}