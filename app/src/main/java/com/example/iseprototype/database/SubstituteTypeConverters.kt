package com.example.iseprototype.database

import androidx.room.TypeConverter
import java.util.*

class SubstituteTypeConverters {

    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?) : String? {
        return uuid?.toString()
    }
}