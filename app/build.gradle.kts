plugins {
    alias(libs.plugins.custom.app)
}
android {
    namespace = "com.bandeev.tz"
    defaultConfig {
        applicationId = "com.bandeev.tz"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:course"))

    implementation(project(":feature:auth"))
    implementation(project(":feature:all_courses"))
    implementation(project(":feature:favourite_courses"))
    implementation(project(":feature:account_management"))

    // Layout
    implementation(libs.androidx.constraintlayout)
}