plugins {
    kotlin("jvm").version("1.8.0")
    id("org.jetbrains.compose").version("1.4.0")
}

dependencies {
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "com.bravepeople.devevent.desktop.MainKt"
    }
}
