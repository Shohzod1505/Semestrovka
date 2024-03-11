package ru.itis.kpfu.feature.auth.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthScreenModel(
    val name: String
) : Parcelable
