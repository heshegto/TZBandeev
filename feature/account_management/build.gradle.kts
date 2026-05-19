plugins {
    alias(libs.plugins.custom.library)
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":feature:auth"))
}