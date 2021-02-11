package com.raedghazal.schoolapp_roomdb_kotlin.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Student
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    ) val subjects: List<Subject>
)