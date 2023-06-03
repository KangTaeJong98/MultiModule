pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        includeBuild("build-logic")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DevEvent-Multi"

include(":android")
include(":desktop")
