package com.example.bitsleep
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var sleepDao: SleepDao
    private val job = Job() // Create a Job for the CoroutineScope
    private val customScope = CoroutineScope(Dispatchers.Main + job) // Combine Dispatcher with Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Room database
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "sleep_database"
        ).build()
        sleepDao = db.sleepDao()

        // Set up RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load data from the database
        customScope.launch {
            val entries = sleepDao.getAllSleepEntries()
            recyclerView.adapter = SleepAdapter(entries)
        }

        // Set up FloatingActionButton to add entries
        findViewById<FloatingActionButton>(R.id.addButton).setOnClickListener {
            startActivity(Intent(this, AddEntryActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel() // Cancel the job to avoid memory leaks
    }
}
