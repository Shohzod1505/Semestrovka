package ru.itis.kpfu.feature.detail.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailScreenModel(
    val name: String?
) : Parcelable
