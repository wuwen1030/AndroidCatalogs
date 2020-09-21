package com.wuwen.catalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wuwen.catalog.adapters.CatalogAdapter
import com.wuwen.catalog.data.CatalogItem
import java.lang.Exception

class CatalogActivity : AppCompatActivity() {
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
        val lifeCycleItem = CatalogItem(
            title = "Lift Cycle",
            subtitle = "Show activity life cycle",
            destination = "com.wuwen.catalog.LifeCycleActivity"
        )
        val viewModelItem = CatalogItem(
            title = "View Model",
            subtitle = "A simple view model demo",
            destination = "com.wuwen.catalog.CounterActivity"
        )
        val fragmentItem = CatalogItem(
            title = "Fragment",
            subtitle = "Fragment demos",
            destination = "com.wuwen.catalog.ArticleActivity"
        )
        dataSet = arrayOf(lifeCycleItem, viewModelItem, fragmentItem)
    }

    companion object {
        const val TAG = "MainActivity"
    }

}