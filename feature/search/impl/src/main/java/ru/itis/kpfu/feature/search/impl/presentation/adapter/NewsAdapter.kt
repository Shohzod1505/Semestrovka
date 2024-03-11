package ru.itis.kpfu.feature.search.impl.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.kpfu.feature.search.impl.presentation.adapter.NewsItem.Companion.VIEW_TYPE_ARTICLE
import ru.itis.kpfu.feature.search.impl.presentation.adapter.NewsItem.Companion.VIEW_TYPE_SOURCE

interface NewsActionListener {
    fun onArticleAction(news: NewsItem.News)
    fun onSourcesAction(source: NewsItem.Source)
}

class NewsAdapter(
    private val glide: RequestManager,
    private val newsActionListener: NewsActionListener,
) : ListAdapter<NewsItem, RecyclerView.ViewHolder>(NewsDiff) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder =
        when(viewType) {
            VIEW_TYPE_ARTICLE -> {
                NewsHolder.create(parent, glide, newsActionListener)
            }
//            VIEW_TYPE_SOURCE -> {
//                SourceHolder.create(parent, glide, newsActionListener)
//            }
            else -> throw IllegalArgumentException("Invalid view type")
        }


    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
    ) {
        when(holder) {
            is NewsHolder -> holder.onBind(getItem(position) as NewsItem.News)
//            is SourceHolder -> holder.onBind(getItem(position) as NewsItem.Source)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is NewsItem.News -> VIEW_TYPE_ARTICLE
            is NewsItem.Source -> VIEW_TYPE_SOURCE
        }
    }

    fun articleSubmitList(list: MutableList<NewsItem.News>?) {
        super.submitList(list?.map { it.copy() })
    }

    fun sourceSubmitList(list: MutableList<NewsItem.Source>?) {
        super.submitList(list?.map { it.copy() })
    }

}
