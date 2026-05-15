plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("baseModule") {
            id = libs.plugins.custom.base.get().pluginId
            implementationClass = "BaseModuleConventionPlugin"
        }
        register("standardModule") {
            id = libs.plugins.custom.standard.get().pluginId
            implementationClass = "StandardModuleConventionPlugin"
        }
    }
}
