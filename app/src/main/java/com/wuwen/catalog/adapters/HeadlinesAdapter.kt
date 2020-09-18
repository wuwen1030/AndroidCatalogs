package com.wuwen.catalog.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wuwen.catalog.R
import com.wuwen.catalog.data.Article
import com.wuwen.catalog.databinding.ListItemHeadlineBinding

class HeadlinesAdapter(private val onClickListener: (Article) -> Unit): ListAdapter<Article, HeadlinesAdapter.ViewHolder>(
    ArticleDiffCallback()
) {
    class ViewHolder(
        val binding: ListItemHeadlineBinding
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
                R.layout.list_item_headline,
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