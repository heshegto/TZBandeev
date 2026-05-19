package projectExtensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

fun Project.configureTestOptions(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        defaultConfig {
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }
}