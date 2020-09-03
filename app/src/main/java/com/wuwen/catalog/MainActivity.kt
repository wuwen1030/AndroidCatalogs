package com.wuwen.catalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var dataSet: Array<CatalogItem>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDataSet()
        val viewManager = LinearLayoutManager(this)
        val viewAdapter = CatalogAdapter(dataSet) { position, item ->
            Log.v(TAG, "Click item at index: $position")
            try {
                val clz = Class.forName(item.destination)
                val intent = Intent(this, clz)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }

        recyclerView = findViewById<RecyclerView>(R.id.recycleView).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun initDataSet() {
        val lifeCycle = CatalogItem(
            title = "Lift Cycle",
            subtitle = "Show activity life cycle",
            destination = "com.wuwen.catalog.lifecycle.MainActivity"
        )
        dataSet = arrayOf(lifeCycle)
    }

    companion object {
        const val TAG = "MainActivity"
    }

}