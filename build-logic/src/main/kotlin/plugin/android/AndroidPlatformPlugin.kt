package plugin.android

import Build
import com.android.build.api.dsl.CommonExtension
import ext.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

internal class AndroidPlatformPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        applyPlugin(target.pluginManager)
        applyKotlinOptions(target.extensions.getByType(CommonExtension::class))
    }

    private fun applyPlugin(manager: PluginManager) = with(manager) {
        apply("org.jetbrains.kotlin.android")
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
}