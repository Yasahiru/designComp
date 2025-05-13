package com.cmc.compdesign.presentation.viewmodel

import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {
    var name: String? = null
    var email: String? = null
    var password: String? = null

    var pregnancyWeek: Int? = null
    var age: Int? = null
    var isFirstPregnancy: String? = null

    var babyGender: String? = null
    var medsTaken: String? = null
    var babyHealth: String? = null

    fun setAccountInfo(name: String, email: String, password: String) {
        this.name = name
        this.email = email
        this.password = password
    }

    fun setPersonalInfo(week: String, age: String, firstPreg: String) {
        this.pregnancyWeek = week
        this.age = age
        this.isFirstPregnancy = firstPreg
    }

    fun setBabyInfo(gender: String, meds: String, health: String) {
        this.babyGender = gender
        this.medsTaken = meds
        this.babyHealth = health
    }
}
