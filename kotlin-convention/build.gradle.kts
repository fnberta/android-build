// TODO: Remove once KTIJ-19369 is fixed
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    `maven-publish`
    alias(libs.plugins.spotless)
}

group = "com.github.fnberta.kotlinbuild"

version = "0.0.1"

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

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
    implementation(libs.detekt.gradlePlugin)
    implementation(libs.depVersions.gradlePlugin)
    implementation(libs.catalog.update.gradlePlugin)
}

fun Project.getEnvOrPropertyOrThrow(key: String): String =
    providers.environmentVariable(key).getOrElse(providers.gradleProperty(key).get())
