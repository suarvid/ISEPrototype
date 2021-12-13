package com.example.iseprototype

import android.content.Context

class DosageCalculator() {

    // Works like a synthetic FASS, hard-coded for the two packages we've gotten
    fun calculateDosagesForCode(code: String): String {

        return when (code) {
            "6432100038319" -> calculateDosageForName("Flucloxacillin")
            "7323281001638" -> calculateDosageForName("Haldol")
            else -> "Could not calculate correct dosage for medication."
        }
    }

    private fun calculateDosageForName(name: String): String {
        // What to do if several substitutes are found? Now we just use the first one
        val substituteNames = Repository.get().getSubstitutesFor(name)
        val foundPrescription = Repository.get().getPrescriptionByName(substituteNames[0])
        return foundPrescription.stringRepDosages()
    }
}