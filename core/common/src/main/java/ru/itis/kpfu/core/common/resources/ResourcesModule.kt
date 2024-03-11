package ru.itis.kpfu.core.common.resources

import dagger.Binds
import dagger.Module

@Module
interface ResourcesModule {

    @Binds
    fun bindResourcesProvider(resourcesImpl: ResourcesImpl): Resources

}
