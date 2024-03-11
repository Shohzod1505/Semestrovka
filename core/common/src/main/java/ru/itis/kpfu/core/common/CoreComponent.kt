package ru.itis.kpfu.core.common

import android.app.Application
import dagger.Component
import ru.itis.kpfu.core.common.app.AndroidModule
import ru.itis.kpfu.core.common.resources.ResourcesModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidModule::class,
        ResourcesModule::class,
    ]
)

interface CoreComponent : CoreProvider {

    fun inject(application: Application)

    companion object {
        fun create(app: Application): CoreProvider {

            return DaggerCoreComponent.builder()
                .androidModule(AndroidModule(app))
                .build()
        }
    }
}
