package projectExtensions

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureBaseLibraries() {
    val libs = getLibs()

    dependencies {
        add("implementation", libs.findLibrary("material").get())
    }
}