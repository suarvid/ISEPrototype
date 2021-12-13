package com.example.iseprototype.database

import androidx.room.TypeConverter
import java.lang.StringBuilder
import java.util.*

class PrescribedDrugTypeConverters {

    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }

    @TypeConverter
    fun fromIntArray(dosages: IntArray?): String? {
        dosages.toString()
        val builder = StringBuilder()
        if (dosages != null) {
            for (dose in dosages) {
                builder.append(dose)
                builder.append(',')
            }

            return builder.toString()
        }

        return ""
    }

    @TypeConverter
    fun toIntArray(string: String?): IntArray? {
        val dosageArray = intArrayOf(0, 0, 0, 0)
        val list = string?.split(",")
        if (list != null) {
            for (i in 0..list.size) {
                dosageArray[i] = list[i].toInt()
            }
        }

        return dosageArray
    }
}