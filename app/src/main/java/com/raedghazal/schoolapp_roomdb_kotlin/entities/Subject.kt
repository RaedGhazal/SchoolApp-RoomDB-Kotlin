package com.raedghazal.schoolapp_roomdb_kotlin.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject (
    @PrimaryKey(autoGenerate = false)
        val subjectName: String
)