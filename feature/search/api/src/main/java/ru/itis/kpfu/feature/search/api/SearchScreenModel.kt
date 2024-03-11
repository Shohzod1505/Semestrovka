package ru.itis.kpfu.feature.search.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchScreenModel(
    val name: String
) : Parcelable
