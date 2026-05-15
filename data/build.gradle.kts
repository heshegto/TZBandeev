plugins {
    alias(libs.plugins.custom.standard)
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(project(":domain"))
    // Room
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    // Retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter.gson)
}