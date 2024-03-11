package ru.itis.kpfu.feature.auth.impl.presentation

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.base.BaseFragment
import ru.itis.kpfu.feature.auth.api.AuthScreenModel
import ru.itis.kpfu.feature.auth.impl.databinding.FragmentAuthBinding
import ru.itis.kpfu.feature.auth.impl.di.AuthComponent

private const val ARG_KEY_MODEL = "ARG_KEY_MODEL"

internal class AuthFragment : BaseFragment<AuthViewModel, FragmentAuthBinding>(
    inflate = FragmentAuthBinding::inflate
) {
    override val viewModel: AuthViewModel by viewModels { viewModelFactory }

    override fun inject(applicationProvider: ApplicationProvider) {
        AuthComponent.init(
            applicationProvider = applicationProvider,
            model = arguments?.getParcelable(ARG_KEY_MODEL) ?: error("No model received")
        ).inject(this)
    }

    companion object {

        fun createInstance(model: AuthScreenModel) = AuthFragment().apply {
            arguments = bundleOf(ARG_KEY_MODEL to model)
        }
    }

}
