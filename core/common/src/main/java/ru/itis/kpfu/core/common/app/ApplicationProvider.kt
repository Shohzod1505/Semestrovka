package ru.itis.kpfu.core.common.app

import ru.itis.kpfu.core.common.CoreProvider
import ru.itis.kpfu.core.database.di.DatabaseProvider
import ru.itis.kpfu.core.navigation.NavigationProvider
import ru.itis.kpfu.core.navigation.ScreensMapProvider
import ru.itis.kpfu.core.network.di.NetworkProvider

interface ApplicationProvider :
    CoreProvider,
    DatabaseProvider,
    NetworkProvider,
    NavigationProvider,
    ScreensMapProvider
