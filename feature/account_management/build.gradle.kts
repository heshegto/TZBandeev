plugins {
    alias(libs.plugins.custom.standard)
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":feature:auth"))
}