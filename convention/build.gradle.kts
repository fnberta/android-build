// TODO: Remove once KTIJ-19369 is fixed
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    id("maven-publish")
    alias(libs.plugins.spotless)
}

group = "com.github.fnberta.androidbuild"

version = "0.0.1"

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/fnberta/android-build")
            credentials {
                username =
                    providers
                        .environmentVariable("GITHUB_USER")
                        .getOrElse(providers.gradleProperty("GITHUB_USER").get())
                password =
                    providers
                        .environmentVariable("GITHUB_TOKEN")
                        .getOrElse(providers.gradleProperty("GITHUB_TOKEN").get())
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
    implementation(libs.hilt.gradlePlugin)
}
