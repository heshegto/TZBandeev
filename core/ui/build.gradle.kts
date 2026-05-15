plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.bandeev.core.ui"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(libs.material)
}