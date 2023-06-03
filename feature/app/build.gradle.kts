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
        val commonMain by getting {
            dependencies {
                api(compose.ui)
                api(compose.runtime)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.app"
}