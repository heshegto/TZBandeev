plugins {
    alias(libs.plugins.custom.library)
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    // Layout
    implementation(libs.androidx.cardview)
}