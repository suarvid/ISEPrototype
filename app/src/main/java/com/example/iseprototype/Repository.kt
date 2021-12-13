package com.example.iseprototype

import android.content.Context
import androidx.room.Room
import com.example.iseprototype.database.Database
import java.lang.IllegalStateException

private const val DATABASE_NAME = "database"

class Repository private constructor(context: Context) {

    private val database: Database = Room.databaseBuilder(
        context.applicationContext,
        Database::class.java,
        DATABASE_NAME
    ).build()

    private val dao = database.dao()

    fun getDrugs(): List<PrescribedDrug> = dao.getDrugs()

    // What to do if several matches are found? Now we just grab the first match
    fun getPrescriptionByName(name: String): PrescribedDrug = dao.getPrescriptionByName(name)[0]

    fun getSubstitutes(): List<String> = dao.getSubstitutes()

    fun getSubstitutesFor(name: String): List<String> = dao.getSubstitutesFor(name)

    companion object {
        private var INSTANCE: Repository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Repository(context)
            }
        }

        fun get(): Repository {
            return INSTANCE?: throw IllegalStateException("Repository must be initialized")
        }
    }
}