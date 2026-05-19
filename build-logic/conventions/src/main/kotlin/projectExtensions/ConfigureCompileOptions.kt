package projectExtensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

fun Project.configureCompileOptions(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    val libs = getLibs()
    val jvmTargetStr = libs.findVersion("jvmTarget").get().toString()

    commonExtension.apply {
        compileOptions {
            sourceCompatibility = JavaVersion.toVersion(jvmTargetStr)
            targetCompatibility = JavaVersion.toVersion(jvmTargetStr)
        }
    }

    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(jvmTargetStr))
        }
    }
}