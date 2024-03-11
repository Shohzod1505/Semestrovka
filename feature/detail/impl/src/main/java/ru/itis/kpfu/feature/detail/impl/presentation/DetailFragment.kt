package ru.itis.kpfu.feature.detail.impl.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.base.BaseFragment
import ru.itis.kpfu.core.common.utils.withArguments
import ru.itis.kpfu.feature.auth.impl.databinding.FragmentDetailBinding
import ru.itis.kpfu.feature.detail.impl.di.DetailComponent
import ru.itis.kpfu.feature.detail.api.DetailScreenModel

private const val ARG_KEY_MODEL = "ARG_KEY_MODEL"
private const val ARG_KEY_QUERY = "ARG_KEY_QUERY"

internal class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>(
    inflate = FragmentDetailBinding::inflate
) {
    override val viewModel: DetailViewModel by viewModels { viewModelFactory }

    override fun inject(applicationProvider: ApplicationProvider) {
        DetailComponent.init(
            applicationProvider = applicationProvider,
            model = arguments?.getParcelable(ARG_KEY_MODEL) ?: error("No model received")
        ).inject(this)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val query = arguments?.getString(ARG_KEY_QUERY)
        Log.e("MY", query.toString())
        if (query != null) {
            lifecycleScope.launch {
                val news = viewModel.getNews(query).articles?.firstOrNull()

                with(binding) {
                    Glide.with(this@DetailFragment)
                        .load(news?.urlToImage)
                        .into(ivPhoto)
                    tvTitle.text = news?.title
                    tvDate.text = news?.publishedAt
                    tvSource.text = news?.source?.name
                    tvNews.text = news?.content
                }
            }
        }
    }

    companion object {

        fun createInstance(model: DetailScreenModel, query: String) = DetailFragment()
            .withArguments {
                putParcelable(ARG_KEY_MODEL, model)
                putString(ARG_KEY_QUERY, query)
            }
    }

}
