package com.example.practice4_on_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dates = readDatesFromFile()
        val adapter = MyAdapter(dates)
        recyclerView.adapter = adapter
    }

    private fun readDatesFromFile(): List<String> {
        val file = File(filesDir, "photos/date.txt")
        if (!file.exists()) return emptyList()

        return file.readLines().sorted()
    }
}