package com.wuwen.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatalogAdapter(private val dataSet: Array<CatalogItem>, private val onItemClick: (Int, CatalogItem) -> Unit) : RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val titleView: TextView = v.findViewById(R.id.catalogItemTitle)
        val subtitleView: TextView = v.findViewById(R.id.catalogItemSubtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.catalog_row, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = dataSet[position].title
        holder.subtitleView.text = dataSet[position].subtitle
        holder.itemView.setOnClickListener {
            onItemClick(position, dataSet[position])
        }
    }


    override fun getItemCount() = dataSet.size

    companion object {
        private const val TAG = "CatalogAdapter"
    }
}