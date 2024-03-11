plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-parcelize`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.feature.auth.impl"
}

dependencies {
    implementation(projects.feature.saved.api)
    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(projects.core.network)
    implementation(projects.core.navigation)

    implementation(libs.bundles.ktx)
    implementation(libs.bundles.ui)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.cicerone)
    implementation(libs.bundles.coroutines)
}
