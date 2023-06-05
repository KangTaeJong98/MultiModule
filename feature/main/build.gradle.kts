plugins {
    kotlin("multiplatform").version("1.8.20")
    id("event.android.lib")
    id("org.jetbrains.compose").version("1.4.0")
}

kotlin {
    android()
    jvm("desktop") {
        jvmToolchain(17)
    }

    sourceSets {
        maybeCreate("commonMain")
        getByName("commonMain") {
            dependencies {
                implementation(project(":navigation"))

                api(compose.ui)
                api(compose.runtime)
                api(compose.material3)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.main"
}