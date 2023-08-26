package com.github.fnberta.kotlinbuild

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

private const val JDK_VERSION = 17

internal fun Project.configureKotlin() {
    kotlin { jvmToolchain(JDK_VERSION) }
}

private fun Project.kotlin(action: KotlinAndroidProjectExtension.() -> Unit) {
    extensions.configure(action)
}
