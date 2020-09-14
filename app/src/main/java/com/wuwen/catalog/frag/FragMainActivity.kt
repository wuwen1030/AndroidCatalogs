package com.wuwen.catalog.frag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.wuwen.catalog.R
import com.wuwen.catalog.WithBackActivity

class FragMainActivity : WithBackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_main)
        actionBar?.title = "Fragment Sample"
        if (savedInstanceState == null) {
            val headlinesFragment = HeadlinesFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, headlinesFragment).commit()
        }
    }
}