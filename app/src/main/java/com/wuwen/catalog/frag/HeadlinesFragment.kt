package com.wuwen.catalog.frag

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.wuwen.catalog.R
import com.wuwen.catalog.databinding.HeadlinesFragmentBinding

class HeadlinesFragment : Fragment() {

    private lateinit var fragmentBinding: HeadlinesFragmentBinding
    companion object {
        fun newInstance() = HeadlinesFragment()
    }

    private lateinit var viewModel: HeadlinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = HeadlinesFragmentBinding.inflate(inflater, container, false)
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