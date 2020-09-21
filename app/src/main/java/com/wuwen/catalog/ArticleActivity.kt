package com.wuwen.catalog

import android.os.Bundle
import com.wuwen.catalog.ui.HeadlinesFragment
import com.wuwen.catalog.utilities.WithBackActivity

class ArticleActivity : WithBackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_main)
        supportActionBar?.title = "Fragment Sample"
        if (savedInstanceState == null) {
            val headlinesFragment = HeadlinesFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, headlinesFragment).commit()
        }
    }
}