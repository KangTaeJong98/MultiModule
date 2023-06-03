plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)

    explicitApi()
}

dependencies {
    implementation(libs.gradle.kotlin)
    implementation(libs.gradle.android)
}

gradlePlugin {
    plugins {
        register("event.android.app") {
            id = "event.android.app"
            implementationClass = "plugin.android.AndroidAppPlugin"
        }
    }
}