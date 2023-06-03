package plugin.android

import Build
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal class AndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyAndroidExtension(target.extensions.getByType(CommonExtension::class))
        applyCompileOptions(target.extensions.getByType(CommonExtension::class))
        applyBuildTypes(target.extensions.getByType(CommonExtension::class))
    }

    private fun applyAndroidExtension(extension: CommonExtension<*, *, *, *>) = with(extension) {
        compileSdk = Build.ANDROID_COMPILE_SDK

        applyDefaultConfig(defaultConfig)
    }

    private fun applyDefaultConfig(config: DefaultConfig) = with(config) {
        minSdk = Build.ANDROID_MIN_SDK
    }

    private fun applyCompileOptions(extension: CommonExtension<*, *, *, *>) = with(extension) {
        compileOptions {
            sourceCompatibility = Build.SOURCE_COMPATIBILITY
            targetCompatibility = Build.TARGET_COMPATIBILITY
        }
    }

    private fun applyBuildTypes(extension: CommonExtension<*, *, *, *>) = with(extension) {
        buildTypes {
            maybeCreate("release")
            getByName("release") {
                isMinifyEnabled = true
            }
        }
    }
}