plugins {
    alias(libs.plugins.custom.library)
}

dependencies {
    implementation(project(":core:ui"))
    implementation("androidx.activity:activity-ktx:1.9.3")
}