package com.example.bitsleep

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddEntryActivity : AppCompatActivity() {

    private lateinit var sleepDao: SleepDao
    private val job = Job() // Create a Job for the CoroutineScope
    private val customScope = CoroutineScope(Dispatchers.Main + job) // Combine Dispatcher with Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)

        // Initialize Room database
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "sleep_database"
        ).build()
        sleepDao = db.sleepDao()

        // Find views
        val dateInput = findViewById<EditText>(R.id.dateInput)
        val hoursInput = findViewById<EditText>(R.id.hoursInput)
        val saveButton = findViewById<Button>(R.id.saveButton)

        // Set click listener for Save button
        saveButton.setOnClickListener {
            val date = dateInput.text.toString()
            val hours = hoursInput.text.toString().toIntOrNull()

            // Validate inputs
            if (date.isNotBlank() && hours != null) {
                val newEntry = SleepEntry(date = date, hoursSlept = hours)

                // Insert entry into the database using customScope
                customScope.launch {
                    sleepDao.insertSleepEntry(newEntry)
                    finish() // Go back to MainActivity
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel() // Cancel the job to avoid memory leaks
    }
}
