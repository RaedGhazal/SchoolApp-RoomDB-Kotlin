package com.raedghazal.schoolapp_roomdb_kotlin.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class School (
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)