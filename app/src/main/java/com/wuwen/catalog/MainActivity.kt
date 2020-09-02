package com.wuwen.catalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var dataSet: Array<CatalogItem>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDataSet()
        val viewManager = LinearLayoutManager(this)
        val viewAdapter = CatalogAdapter(dataSet) { position, item ->
            val clz = Class.forName(item.destination)
            val intent = Intent(this, clz)
            startActivity(intent)
        }

        recyclerView = findViewById<RecyclerView>(R.id.recycleView).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    fun initDataSet() {
        val lifeCycle = CatalogItem(
            title = "Lift Cycle",
            subtitle = "Show activity life cycle",
            destination = "com.wuwen.catalog.lifecycle.MainActivity"
        )
        dataSet = arrayOf(lifeCycle)
    }
}