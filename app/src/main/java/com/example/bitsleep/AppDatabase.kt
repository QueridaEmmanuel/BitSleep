package com.example.bitsleep

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SleepEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sleepDao(): SleepDao
}
