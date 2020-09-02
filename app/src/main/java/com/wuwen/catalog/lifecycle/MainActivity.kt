package com.wuwen.catalog.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wuwen.catalog.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_main)
    }
}