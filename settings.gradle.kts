enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")


pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Semestrovka"
include(":app")
include(":core:database")
include(":core:navigation")
include(":core:network")
include(":core:common")
include(":feature:auth:api")
include(":feature:auth:impl")
include(":feature:search:api")
include(":feature:search:impl")
include(":feature:saved:impl")
include(":feature:saved:api")
include(":feature:detail:impl")
include(":feature:detail:api")
include(":core:designsystem")
