package com.wuwen.catalog.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wuwen.catalog.R
import com.wuwen.catalog.adapters.HeadlinesAdapter
import com.wuwen.catalog.data.Article
import com.wuwen.catalog.databinding.FragmentHeadlinesBinding
import com.wuwen.catalog.viewmodels.HeadlinesViewModel

class HeadlinesFragment : Fragment() {

    private lateinit var fragmentBinding: FragmentHeadlinesBinding
    companion object {
        fun newInstance() = HeadlinesFragment()
    }

    private lateinit var viewModel: HeadlinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = FragmentHeadlinesBinding.inflate(inflater, container, false)
        val adapter = HeadlinesAdapter {article ->
            onItemClick(article)
        }
        fragmentBinding.headlineList.adapter = adapter
        viewModel = ViewModelProviders.of(this).get(HeadlinesViewModel::class.java)
        viewModel.articles.observe(viewLifecycleOwner) { result ->
            adapter.submitList(result)
        }
        return fragmentBinding.root
    }

    private fun onItemClick(article: Article) {
        val articleFragment = ArticleFragment.newInstance(article)
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, articleFragment)
            addToBackStack(null)
            commit()
        }
    }

}