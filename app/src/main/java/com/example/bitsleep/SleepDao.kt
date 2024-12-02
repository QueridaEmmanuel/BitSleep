package com.example.bitsleep

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SleepDao {

    @Insert
    suspend fun insertSleepEntry(sleepEntry: SleepEntry)

    @Query("SELECT * FROM sleep_entries ORDER BY id DESC")
    suspend fun getAllSleepEntries(): List<SleepEntry>
}
