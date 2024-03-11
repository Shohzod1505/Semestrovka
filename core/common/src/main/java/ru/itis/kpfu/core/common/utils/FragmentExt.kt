package ru.itis.kpfu.core.common.utils

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <T : Fragment> T.withArguments(block: Bundle.() -> Unit): T =
    apply { arguments = Bundle().apply(block) }
