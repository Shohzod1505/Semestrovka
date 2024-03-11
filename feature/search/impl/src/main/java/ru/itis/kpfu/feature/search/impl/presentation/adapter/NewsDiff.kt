package ru.itis.kpfu.feature.search.impl.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

object NewsDiff : DiffUtil.ItemCallback<NewsItem>(){
    override fun areItemsTheSame(
        oldItem: NewsItem,
        newItem: NewsItem
    ): Boolean = oldItem.itemId == newItem.itemId

    override fun areContentsTheSame(
        oldItem: NewsItem,
        newItem: NewsItem,
    ): Boolean = oldItem == newItem
}
