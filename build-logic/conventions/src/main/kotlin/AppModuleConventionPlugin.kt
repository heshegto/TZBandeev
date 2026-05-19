import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.AppExtension
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

class AppModuleConventionPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()

        // Plugins block: defining the project type and language support
        plugins.apply(libs.findPlugin("android.application").get().get().pluginId)
        plugins.apply(libs.findPlugin("kotlin.android").get().get().pluginId)

        // Android block: SDK versions, namespace, and build types
        extensions.configure<AppExtension> {
            configureBase(this as CommonExtension<*, *, *, *, *, *>)
            configureCompileOptions(this)
            configureTestOptions(this)
            configureBuildType(this)

            configureBaseLibraries()
            configureCommonLiraries()
        }
    }
}
