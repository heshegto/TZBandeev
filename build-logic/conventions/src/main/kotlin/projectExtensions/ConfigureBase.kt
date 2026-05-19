package projectExtensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

fun Project.configureBase(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    val libs = getLibs()

    commonExtension.apply {
        namespace = "com.bandeev.$modulePackageName"
        compileSdk = libs.findVersion("compileSdk").get().toString().toInt()

        defaultConfig {
            minSdk = libs.findVersion("minSdk").get().toString().toInt()
        }
    }
}
