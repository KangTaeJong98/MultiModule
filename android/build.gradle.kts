plugins {
    id("org.jetbrains.compose")
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
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.7.2")
}
