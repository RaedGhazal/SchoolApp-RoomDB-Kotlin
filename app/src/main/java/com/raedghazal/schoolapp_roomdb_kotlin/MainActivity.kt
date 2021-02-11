package com.raedghazal.schoolapp_roomdb_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Director
import com.raedghazal.schoolapp_roomdb_kotlin.entities.School
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Student
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Subject
import com.raedghazal.schoolapp_roomdb_kotlin.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = SchoolDatabase.getInstance(this).schoolDao

        val director = listOf(
            Director("Hijawii","IT Department"),
            Director("Fadi","CS Department"),
            Director("Yousef","SE Department"),
        )
        val schools = listOf(
            School("IT Department"),
            School("CS Department"),
            School("SE Department"),
        )
        val subjects = listOf(
            Subject("C++"),
            Subject("Java"),
            Subject("Data Structure"),
        )
        val students = listOf(
            Student("Raed",4,"IT Department"),
            Student("Youse",5,"CS Department"),
            Student("Baraa",3,"SE Department"),
        )
        val studentSubjectCrossRef = listOf(
            StudentSubjectCrossRef("Raed","C++"),
            StudentSubjectCrossRef("Raed","Java"),
            StudentSubjectCrossRef("Youse","Java"),
            StudentSubjectCrossRef("Youse","Data Structure"),
            StudentSubjectCrossRef("Baraa","Data Structure"),
            StudentSubjectCrossRef("Baraa","Java"),
            StudentSubjectCrossRef("Baraa","C++"),
        )

        lifecycleScope.launch {
            director.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectCrossRef.forEach { dao.insertStudentSubjectCrossRef(it) }
        }
    }
}