plugins {
    `kotlin-dsl`
    id("maven-publish")
}

group = "com.github.fnberta.androidbuild"
version = "0.0.1"

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/fnberta/android-build")
            credentials {
                username = providers.environmentVariable("GITHUB_USER")
                    .getOrElse(providers.gradleProperty("GITHUB_USER").get())
                password = providers.environmentVariable("GITHUB_TOKEN")
                    .getOrElse(providers.gradleProperty("GITHUB_TOKEN").get())
            }
        }
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
    implementation(libs.detekt.gradlePlugin)
    implementation(libs.hilt.gradlePlugin)
}
