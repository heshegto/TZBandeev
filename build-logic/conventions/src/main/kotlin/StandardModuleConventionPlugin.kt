import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

class StandardModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()
        val javaVersionStr = libs.findVersion("jvmTarget").get().toString()

        // This things are in custom.base plugin
        // plugin.android.library
        // namespace
        // compileSdk
        // minSdk
        // material library implementation

        // Plugins block: defining the project type and language support
        plugins.apply(libs.findPlugin("custom.base").get().get().pluginId)
        plugins.apply(libs.findPlugin("kotlin.android").get().get().pluginId)

        // Android block: SDK versions, namespace, and build types
        extensions.configure<LibraryExtension> {
            defaultConfig {
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.toVersion(javaVersionStr)
                targetCompatibility = JavaVersion.toVersion(javaVersionStr)
            }
        }

        tasks.withType<KotlinJvmCompile>().configureEach {
            compilerOptions {
                jvmTarget.set(JvmTarget.fromTarget(javaVersionStr))
            }
        }

        // Dependencies block: library and module declarations
        dependencies {
            // Base
            add("implementation", libs.findLibrary("androidx.core.ktx").get())
            add("implementation", libs.findLibrary("androidx.appcompat").get())

            // Koin
            add("implementation", libs.findLibrary("koin.core").get())
            add("implementation", libs.findLibrary("koin.android").get())

            // Test
            add("testImplementation", libs.findLibrary("junit").get())
            add("androidTestImplementation", libs.findLibrary("androidx.junit").get())
            add("androidTestImplementation", libs.findLibrary("androidx.espresso.core").get())
            add("testImplementation", libs.findLibrary("koin.test").get())
        }
    }
}