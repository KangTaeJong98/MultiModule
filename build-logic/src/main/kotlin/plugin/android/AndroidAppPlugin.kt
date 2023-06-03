package plugin.android

import Build
import com.android.build.api.dsl.ApplicationDefaultConfig
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import ext.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

internal class AndroidAppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyPlugin(target.pluginManager)
        applyAndroidExtension(target.extensions.getByType())
        applyCompileOptions(target.extensions.getByType(CommonExtension::class))
        applyKotlinOptions(target.extensions.getByType(CommonExtension::class))
        applyBuildTypes(target.extensions.getByType(CommonExtension::class))
    }

    private fun applyPlugin(manager: PluginManager) = with(manager) {
        apply("com.android.application")
        apply("org.jetbrains.kotlin.android")
    }

    private fun applyAndroidExtension(extension: ApplicationExtension) = with(extension) {
        compileSdk = Build.ANDROID_COMPILE_SDK

        applyDefaultConfig(defaultConfig)
    }

    private fun applyDefaultConfig(config: ApplicationDefaultConfig) = with(config) {
        minSdk = Build.ANDROID_MIN_SDK
        targetSdk = Build.ANDROID_TARGET_SDK
    }

    private fun applyCompileOptions(extension: CommonExtension<*, *, *, *>) = with(extension) {
        compileOptions {
            sourceCompatibility = Build.SOURCE_COMPATIBILITY
            targetCompatibility = Build.TARGET_COMPATIBILITY
        }
    }

    private fun applyKotlinOptions(extension: CommonExtension<*, *, *, *>) = with(extension) {
        kotlinOptions {
            jvmTarget = Build.JVM_TARGET
            freeCompilerArgs = buildList {
                addAll(freeCompilerArgs)
                add("-Xexplicit-api=strict")
            }
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