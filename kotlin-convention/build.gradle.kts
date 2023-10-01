plugins {
    `kotlin-dsl`
    `maven-publish`
    alias(libs.plugins.spotless)
}

group = "com.github.fnberta.kotlinbuild"

version = "0.1.0"

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/fnberta/kotlin-build")
            credentials {
                username = getEnvOrPropertyOrThrow("GITHUB_USER")
                password = getEnvOrPropertyOrThrow("GITHUB_TOKEN")
            }
        }
    }
}

fun Project.getEnvOrPropertyOrThrow(key: String): String =
    providers.environmentVariable(key).getOrElse(providers.gradleProperty(key).get())

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("${layout.buildDirectory}/**/*.kt")
        ktfmt().kotlinlangStyle()
    }
    kotlinGradle {
        target("**/*.kts")
        targetExclude("${layout.buildDirectory}/**/*.kts")
        ktfmt().kotlinlangStyle()
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
    implementation(libs.detekt.gradlePlugin)
    implementation(libs.dependencies.gradlePlugin)
    implementation(libs.catalog.update.gradlePlugin)
}
