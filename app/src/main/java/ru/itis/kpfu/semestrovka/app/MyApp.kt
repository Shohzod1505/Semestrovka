package ru.itis.kpfu.semestrovka.app

import android.app.Application
import ru.itis.kpfu.core.common.app.App
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.semestrovka.di.ApplicationComponent


class MyApp: Application(), App {

    private lateinit var appComponent: ApplicationProvider

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.init(this)
    }

    override fun getApplicationProvider(): ApplicationProvider {
        return appComponent
    }

}
