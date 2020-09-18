package com.wuwen.catalog.frag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wuwen.catalog.databinding.HeadlineItemBinding
import com.wuwen.catalog.R

class HeadlinesAdapter(private val onClickListener: (Article) -> Unit): ListAdapter<Article, HeadlinesAdapter.ViewHolder>(
    ArticleDiffCallback()
) {
    class ViewHolder(
        val binding: HeadlineItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.headline_item,
                parent,
                false
            )
        )
        viewHolder.binding.root.setOnClickListener {
            viewHolder.binding.article?.let {
                onClickListener(it)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class ArticleDiffCallback: DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title && oldItem.content == newItem.content
    }
}