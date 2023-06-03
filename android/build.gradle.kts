plugins {
    id("org.jetbrains.compose").version("1.4.0")
    id("event.android.app")
}

android {
    namespace = "${Build.NAMESPACE}.android"

    defaultConfig {
        applicationId = "${Build.NAMESPACE}.android"
        versionCode = 10000
        versionName = "1.0.0"
    }
}

dependencies {
    implementation("androidx.activity:activity-compose:1.7.2")
}
