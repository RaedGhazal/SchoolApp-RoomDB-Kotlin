package com.raedghazal.schoolapp_roomdb_kotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Director
import com.raedghazal.schoolapp_roomdb_kotlin.entities.School
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Student
import com.raedghazal.schoolapp_roomdb_kotlin.entities.Subject
import com.raedghazal.schoolapp_roomdb_kotlin.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Director::class,
        Student::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        /**
         * @Volatile
         * when ever we change the variable value,
         * then this change is immediately visible to other threads
         * so this will help us to prevent race conditions
         */
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}