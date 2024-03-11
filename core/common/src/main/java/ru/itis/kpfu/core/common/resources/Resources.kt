package ru.itis.kpfu.core.common.resources

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface Resources {

    fun getString(@StringRes stringId: Int): String

    fun getDrawable(@DrawableRes resId: Int): Drawable?

    fun getColor(@ColorRes resId: Int): Int

}
