package com.example.iseprototype.database

import androidx.room.Dao
import androidx.room.Query
import com.example.iseprototype.PrescribedDrug
import com.example.iseprototype.Substitute

@Dao
interface DAO {
    @Query("SELECT * FROM prescribeddrug")
    fun getDrugs(): List<PrescribedDrug>

    @Query("SELECT * FROM substitute")
    fun getSubstitutes(): List<Substitute>

    @Query("SELECT substitute FROM substitute WHERE original=(:original)")
    fun getSubstitutesFor(original: String): List<String>
}