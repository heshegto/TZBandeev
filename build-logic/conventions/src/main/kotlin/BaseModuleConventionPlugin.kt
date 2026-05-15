import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class BaseModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()

        // Plugins block: defining the project type and language support
        plugins.apply(libs.findPlugin("android.library").get().get().pluginId)

        // Android block: SDK versions, namespace, and build types
        extensions.configure<LibraryExtension> {
            namespace = "com.bandeev.$modulePackageName"
            compileSdk = libs.findVersion("compileSdk").get().toString().toInt()
            defaultConfig {
                minSdk = libs.findVersion("minSdk").get().toString().toInt()
            }
        }

        // Dependencies block: library and module declarations
        dependencies {
            add("implementation", libs.findLibrary("material").get())
        }
    }
}