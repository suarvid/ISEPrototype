package com.example.iseprototype

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.StringBuilder
import java.util.*


enum class DosageTime {
    MORNING {
        override fun next() = LUNCH
        override fun toString(): String {
            return "in the morning"
        }
    },

    LUNCH {
        override fun next() = AFTERNOON
        override fun toString(): String {
            return "at lunch"
        }
    },

    AFTERNOON {
        override fun next() = NIGHT
        override fun toString(): String {
            return "in the afternoon"
        }
    },

    NIGHT {
        override fun next() = MORNING
        override fun toString(): String {
            return "at night"
        }
    };

    abstract fun next(): DosageTime
    abstract override fun toString(): String
}

@Entity
data class PrescribedDrug(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var name: String = "",
    var activeSubstance: String = "",
    var dosages: IntArray = intArrayOf(0, 0, 0, 0)
) {
    fun stringRepDosages(): String {
        var time = DosageTime.MORNING
        val builder = StringBuilder()
        builder.append("Dosages for ${this.name} are: ")
        builder.append("\n")
        for (i in 0..this.dosages.size) {
            builder.append("Dosage to be taken ")
            builder.append("$time is:")
            builder.append(dosages[i])
            builder.append("\n")
            time = time.next()
        }

        return builder.toString()

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PrescribedDrug

        if (id != other.id) return false
        if (name != other.name) return false
        if (activeSubstance != other.activeSubstance) return false
        if (!dosages.contentEquals(other.dosages)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + activeSubstance.hashCode()
        result = 31 * result + dosages.contentHashCode()
        return result
    }
}