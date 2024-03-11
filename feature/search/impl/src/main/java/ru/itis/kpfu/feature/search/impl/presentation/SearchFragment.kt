package ru.itis.kpfu.feature.search.impl.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.base.BaseFragment
import ru.itis.kpfu.core.common.utils.withArguments
import ru.itis.kpfu.feature.search.api.SearchScreenModel
import ru.itis.kpfu.feature.search.impl.databinding.FragmentSearchBinding
import ru.itis.kpfu.feature.search.impl.di.SearchComponent
import ru.itis.kpfu.feature.search.impl.presentation.adapter.NewsActionListener
import ru.itis.kpfu.feature.search.impl.presentation.adapter.NewsAdapter
import ru.itis.kpfu.feature.search.impl.presentation.adapter.NewsItem
import ru.itis.kpfu.feature.search.impl.presentation.mappers.toListAdapterNews

private const val ARG_KEY_MODEL = "ARG_KEY_MODEL"

internal class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>(
    inflate = FragmentSearchBinding::inflate
) {

    private var newsAdapter: NewsAdapter? = null
    private var newsList: MutableList<NewsItem.News> = mutableListOf()

    override val viewModel: SearchViewModel by viewModels { viewModelFactory }

    override fun inject(applicationProvider: ApplicationProvider) {
        SearchComponent.init(
            applicationProvider = applicationProvider,
            model = arguments?.getParcelable(ARG_KEY_MODEL) ?: error("No model received")
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        addTextListener()
    }

    private fun addTextListener() {
        with(binding) {
            searchView.addTextChangedListener {
                viewModel.onQueryTextChanged(it.toString())
                val query = searchView.text.toString()
                if (query.isNotEmpty()) {
                    lifecycleScope.launch {
                        newsList = async {
                            viewModel.getNews(query).articles
                        }.await()?.toListAdapterNews() as MutableList<NewsItem.News>
                        newsAdapter?.articleSubmitList(newsList.toMutableList())
                    }
                }
            }
        }
    }

    private fun initAdapter() {

        newsAdapter = NewsAdapter(
            glide = Glide.with(this@SearchFragment),
            newsActionListener =  object : NewsActionListener {
                override fun onArticleAction(news: NewsItem.News) {
                    viewModel.onNewsClicked(news.title)
                }
                override fun onSourcesAction(source: NewsItem.Source) {}
            })

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            recyclerView.adapter = newsAdapter
            recyclerView.addItemDecoration(divider)
        }
        newsAdapter?.articleSubmitList(newsList.toMutableList())
    }

    companion object {

        fun createInstance(model: SearchScreenModel) = SearchFragment()
            .withArguments { putParcelable(ARG_KEY_MODEL, model) }
    }

}
