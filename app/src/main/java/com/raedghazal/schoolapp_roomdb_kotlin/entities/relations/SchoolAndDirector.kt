package com.raedghazal.schoolapp_roomdb_kotlin.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Director
import com.raedghazal.schoolapp_roomdb_kotlin.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)