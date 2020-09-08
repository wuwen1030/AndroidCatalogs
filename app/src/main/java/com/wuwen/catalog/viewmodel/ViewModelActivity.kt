package com.wuwen.catalog.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wuwen.catalog.R
import com.wuwen.catalog.WithBackActivity

class ViewModelActivity : WithBackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
    }
}