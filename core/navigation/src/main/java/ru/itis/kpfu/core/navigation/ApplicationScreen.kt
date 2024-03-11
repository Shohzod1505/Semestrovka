package ru.itis.kpfu.core.navigation

/** Provides screens for navigation */
interface ApplicationScreen {
    val screenKey: String get() = this::class.java.name
}
