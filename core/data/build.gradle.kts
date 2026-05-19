plugins {
    alias(libs.plugins.custom.library)
    alias(libs.plugins.ksp)
}

android {
    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        val baseUrl = "\"https://drive.usercontent.google.com/\""
        val pathUrl = "\"u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download\""
        debug {
            buildConfigField("String", "BASE_URL", baseUrl)
            buildConfigField("String", "PATH_URL", pathUrl)
        }
        release {
            buildConfigField("String", "BASE_URL", baseUrl)
            buildConfigField("String", "PATH_URL", pathUrl)
        }
    }
}

dependencies {
    implementation(project(":core:domain"))
    // Room
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    // Retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter.gson)
}