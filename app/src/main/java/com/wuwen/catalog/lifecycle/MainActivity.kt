package com.wuwen.catalog.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.wuwen.catalog.R
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_main)
        textView = findViewById(R.id.textView)
        updateLog("onCreate")
    }

    private fun updateLog(logString: String) {
        val dateString:CharSequence = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date())
        textView.text = "${textView.text}\n$dateString: $logString"
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart: " + this::class.java.name);
        updateLog("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "onRestart: " + this::class.java.name);
        updateLog("onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume: " + this::class.java.name);
        updateLog("onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause: " + this::class.java.name);
        updateLog("onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop: " + this::class.java.name);
        updateLog("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy: " + this::class.java.name);
        updateLog("onDestroy")
    }

    companion object {
        const val TAG = "LifeCycle"
    }
}