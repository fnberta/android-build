plugins { id("com.diffplug.spotless") }

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
