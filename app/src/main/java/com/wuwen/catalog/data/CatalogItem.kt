package com.wuwen.catalog.data

interface ICatalogItem {
    val title: String
    val subtitle: String
    val destination: String
}

data class CatalogItem(
    override val title: String,
    override val subtitle: String,
    override var destination: String
) : ICatalogItem