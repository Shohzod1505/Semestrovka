package ru.itis.kpfu.core.common

import ru.itis.kpfu.core.common.app.AndroidProvider
import ru.itis.kpfu.core.common.resources.Resources

interface CoreProvider : AndroidProvider {

    fun provideResources(): Resources

}
