package com.raedghazal.schoolapp_roomdb_kotlin.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @PrimaryKey(autoGenerate = false)
    val directorName:String,
    val schoolName: String
)