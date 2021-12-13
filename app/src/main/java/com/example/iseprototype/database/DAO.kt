package com.example.iseprototype.database

import androidx.room.Dao
import androidx.room.Query
import com.example.iseprototype.PrescribedDrug
import com.example.iseprototype.Substitute

@Dao
interface DAO {
    @Query("SELECT * FROM prescribeddrug")
    fun getDrugs(): List<PrescribedDrug>

    @Query("SELECT * FROM prescribeddrug WHERE name=(:name)")
    fun getPrescriptionByName(name: String): List<PrescribedDrug>

    @Query("SELECT substitute FROM substitute")
    fun getSubstitutes(): List<String>

    @Query("SELECT substitute FROM substitute WHERE original=(:original)")
    fun getSubstitutesFor(original: String): List<String>
}