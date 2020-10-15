package com.wuwen.catalog.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wuwen.catalog.data.Article
import com.wuwen.catalog.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {
    private lateinit var article: Article
    private lateinit var articleBinding: FragmentArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        articleBinding = FragmentArticleBinding.inflate(inflater, container, false)
        articleBinding.article = article
        return articleBinding.root
    }


    companion object {
        @JvmStatic
        fun newInstance(article: Article) =
            ArticleFragment().apply {
                this.article = article
            }
    }
}