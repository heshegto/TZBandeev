import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

import projectExtensions.configureBase
import projectExtensions.configureBaseLibraries
import projectExtensions.configureBuildType
import projectExtensions.configureCommonLiraries
import projectExtensions.configureCompileOptions
import projectExtensions.configureTestOptions
import projectExtensions.getLibs

class LibraryModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()

        // Plugins block: defining the project type and language support
        plugins.apply(libs.findPlugin("android.library").get().get().pluginId)
        plugins.apply(libs.findPlugin("kotlin.android").get().get().pluginId)

        // Android block: SDK versions, namespace, and build types
        extensions.configure<LibraryExtension> {
            configureBase(this)
            configureCompileOptions(this)
            configureTestOptions(this)
            configureBuildType(this)

            configureBaseLibraries()
            configureCommonLiraries()

            defaultConfig {
                consumerProguardFiles("consumer-rules.pro")
            }
        }
    }
}