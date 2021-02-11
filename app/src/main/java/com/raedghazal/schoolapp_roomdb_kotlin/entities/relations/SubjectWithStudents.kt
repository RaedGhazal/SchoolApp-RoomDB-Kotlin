package com.raedghazal.schoolapp_roomdb_kotlin.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Student
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    ) val students: List<Student>
)