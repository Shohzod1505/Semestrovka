package ru.itis.kpfu.feature.saved.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SavedScreenModel(
    val name: String
) : Parcelable
