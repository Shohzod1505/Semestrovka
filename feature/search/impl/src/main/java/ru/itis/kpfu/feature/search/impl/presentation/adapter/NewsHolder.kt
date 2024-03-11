package ru.itis.kpfu.feature.search.impl.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.kpfu.core.designsystem.R
import ru.itis.kpfu.feature.search.impl.databinding.ItemNewsBinding

class NewsHolder(
    private val actionListener: NewsActionListener,
    private val glide: RequestManager,
    private val binding: ItemNewsBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(news: NewsItem.News) {
        with(binding) {

            tvSources.text = news.source?.name
            tvText.text = news.content

            val logo = when(news.source?.name) {
                "BBC News" -> R.drawable.logo_bbc
                "Fox News" -> R.drawable.logo_foxnews
                "The New York Times" -> R.drawable.logo_thenewyorktimes
                "CBC News" -> R.drawable.logo_cnbc
                "CNN" -> R.drawable.logo_cnn
                "Bloomberg" -> R.drawable.logo_bloomberg
                "Daily Mail" -> R.drawable.logo_dailymail
                else -> R.drawable.logo_placeholder
            }

            glide
                .load(logo)
                .error(R.drawable.photo_placeholder)
                .into(ivLogo)

            glide
                .load(news.urlToImage)
                .error(R.drawable.photo_placeholder)
                .placeholder(R.drawable.photo_placeholder)
                .into(ivPhoto)

            root.setOnClickListener {
                actionListener.onArticleAction(news)
            }

        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            actionListener: NewsActionListener,
        ): NewsHolder = NewsHolder(
            binding = ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            actionListener = actionListener,
        )
    }

}
