package ru.itis.kpfu.core.common.app

import android.app.Application
import android.content.Context

interface AndroidProvider {

    fun provideApplication(): Application

    fun provideContext(): Context
}
