package ch.berta.fabio.kotlinbuild.convention

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureSpotless() {
    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            ktfmt().kotlinlangStyle()
        }
        kotlinGradle {
            target("**/*.kts")
            targetExclude("$buildDir/**/*.kts")
            ktfmt().kotlinlangStyle()
        }
    }
}

private fun Project.spotless(action: SpotlessExtension.() -> Unit) {
    extensions.configure(action)
}
