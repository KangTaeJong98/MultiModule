plugins {
    id("event.android.app")
    id("org.jetbrains.compose").version("1.4.0")
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
    implementation(project(":navigation"))
    implementation(project(":feature:app"))

    implementation(libs.android.material)
    implementation(libs.android.activity.compose)
    implementation(libs.android.navigation.compose)
}
