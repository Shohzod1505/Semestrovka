package ru.itis.kpfu.core.common

import android.app.Application

object CoreFactory {
    fun createCoreProvider(app: Application): CoreProvider {
        return CoreComponent.create(app)
    }
}
