plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-parcelize`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.feature.search.api"
}

dependencies {
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(projects.core.navigation)
    implementation(libs.cicerone)
}
