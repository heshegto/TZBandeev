plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.bandeev.core.ui"
    compileSdk = 36

    defaultConfig {
        minSdk = 28
    }
}

dependencies {
    implementation(libs.material)
}