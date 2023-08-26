package com.github.fnberta.kotlinbuild

import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureDetekt() {
    detekt { config.setFrom("$rootDir/detekt.yml") }
}

private fun Project.detekt(action: DetektExtension.() -> Unit) {
    extensions.configure(action)
}
