plugins {
    kotlin("multiplatform").version("1.8.20")
    id("event.android.lib")
}

kotlin {
    android()
    jvm("desktop") {
        jvmToolchain(17)
    }

    sourceSets {
        maybeCreate("androidMain")
        getByName("androidMain") {
            dependencies {
                implementation(libs.android.navigation)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.navigation"
}