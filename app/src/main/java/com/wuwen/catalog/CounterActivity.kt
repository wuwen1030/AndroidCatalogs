package com.wuwen.catalog

import android.os.Bundle
import com.wuwen.catalog.utilities.WithBackActivity

class CounterActivity : WithBackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_main)
        supportActionBar?.title = "View Model Sample"
    }
}