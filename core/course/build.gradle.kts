plugins {
    alias(libs.plugins.custom.standard)
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core:ui"))
    // Layout
    implementation(libs.androidx.cardview)
}