package plugin.android

import Build
import com.android.build.api.dsl.ApplicationDefaultConfig
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

internal class AndroidAppPlugin : Plugin<Project> {
    private val androidPlugin = AndroidPlugin()
    private val androidPlatformPlugin = AndroidPlatformPlugin()

    override fun apply(target: Project) {
        applyPlugin(target.pluginManager)
        applyAndroidExtension(target.extensions.getByType())

        androidPlugin.apply(target)
        androidPlatformPlugin.apply(target)
    }

    private fun applyPlugin(manager: PluginManager) = with(manager) {
        apply("com.android.application")
    }

    private fun applyAndroidExtension(extension: ApplicationExtension) = with(extension) {
        applyDefaultConfig(defaultConfig)
    }

    private fun applyDefaultConfig(config: ApplicationDefaultConfig) = with(config) {
        targetSdk = Build.ANDROID_TARGET_SDK
    }
}