package projectExtensions

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCommonLiraries() {
    val libs = getLibs()

    dependencies {
        // Base
        add("implementation", libs.findLibrary("androidx.core.ktx").get())
        add("implementation", libs.findLibrary("androidx.appcompat").get())
        // Test
        add("implementation", libs.findLibrary("junit").get())
        add("implementation", libs.findLibrary("androidx.junit").get())
        add("implementation", libs.findLibrary("androidx.espresso.core").get())
        // Koin
        add("implementation", libs.findLibrary("koin.core").get())
        add("implementation", libs.findLibrary("koin.android").get())
        add("implementation", libs.findLibrary("koin.test").get())
    }
}