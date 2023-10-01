package com.github.fnberta.kotlinbuild

import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

private const val JDK_VERSION = 17

internal fun Project.configureAndroidKotlin() {
    kotlinOptions {
        jvmToolchain(JDK_VERSION)
        compilerOptions {
            freeCompilerArgs.add("-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi")
            if (providers.gradleProperty("enableComposeCompilerReports").toBoolean()) {
                addComposeCompilerReports(layout.buildDirectory.dir("composeMetrics"))
            }
        }
    }
}

private fun KotlinJvmCompilerOptions.addComposeCompilerReports(
    targetDirectory: Provider<Directory>
) {
    val path = targetDirectory.get().asFile.path
    freeCompilerArgs.addAll(
        "-P",
        "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=$path"
    )
    freeCompilerArgs.addAll(
        "-P",
        "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=$path"
    )
}

private fun Provider<String>.toBoolean(): Boolean = getOrElse("false").toBoolean()

private fun Project.kotlinOptions(action: KotlinAndroidProjectExtension.() -> Unit) {
    extensions.configure(action)
}

internal fun Project.configureJvmKotlin() {
    kotlin {
        jvmToolchain(JDK_VERSION)
        compilerOptions {
            freeCompilerArgs.add("-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi")
        }
    }
}

private fun Project.kotlin(action: KotlinJvmProjectExtension.() -> Unit) {
    extensions.configure(action)
}
