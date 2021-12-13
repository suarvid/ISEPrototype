package com.example.iseprototype

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Substitute(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var original: String = "",
    var substitute: String = ""
)