package com.wuwen.catalog.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.wuwen.catalog.R
import com.wuwen.catalog.viewmodels.CounterViewModel

class CounterFragment : Fragment() {

    companion object {
        fun newInstance() = CounterFragment()
    }

    private lateinit var viewModel: CounterViewModel
    private lateinit var counterTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterTextView = view.findViewById(R.id.counterView)
        view.findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                viewModel.hit()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)
        viewModel.hitCount.observe(this, Observer<Int> {
            counterTextView.text = "hit: $it"
        })
    }
}