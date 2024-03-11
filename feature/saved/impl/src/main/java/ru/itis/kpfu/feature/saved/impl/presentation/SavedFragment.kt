package ru.itis.kpfu.feature.saved.impl.presentation

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.base.BaseFragment
import ru.itis.kpfu.feature.auth.impl.databinding.FragmentSavedBinding
import ru.itis.kpfu.feature.saved.impl.di.SavedComponent
import ru.itis.kpfu.feature.saved.api.SavedScreenModel

private const val ARG_KEY_MODEL = "ARG_KEY_MODEL"

internal class SavedFragment : BaseFragment<SavedViewModel, FragmentSavedBinding>(
    inflate = FragmentSavedBinding::inflate
) {
    override val viewModel: SavedViewModel by viewModels { viewModelFactory }

    override fun inject(applicationProvider: ApplicationProvider) {
        SavedComponent.init(
            applicationProvider = applicationProvider,
            model = arguments?.getParcelable(ARG_KEY_MODEL) ?: error("No model received")
        ).inject(this)
    }

    companion object {

        fun createInstance(model: SavedScreenModel) = SavedFragment().apply {
            arguments = bundleOf(ARG_KEY_MODEL to model)
        }
    }

}
