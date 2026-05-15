plugins {
    alias(libs.plugins.custom.standard)
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core:course"))
    implementation(project(":core:ui"))
}