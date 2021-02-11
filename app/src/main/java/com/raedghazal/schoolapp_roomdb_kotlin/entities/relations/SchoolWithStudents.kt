package com.raedghazal.schoolapp_roomdb_kotlin.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.raedghazal.schoolapp_roomdb_kotlin.entities.School
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    ) val students: List<Student>
)