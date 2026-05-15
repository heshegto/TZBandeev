plugins {
    alias(libs.plugins.custom.standard)
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":core:ui"))
    implementation(project(":core:course"))

    implementation(libs.androidx.recyclerview)
}