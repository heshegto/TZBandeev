plugins {
    alias(libs.plugins.custom.library)
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:course"))
}