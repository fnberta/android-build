plugins { id("io.gitlab.arturbosch.detekt") }

detekt { config.setFrom("$rootDir/detekt.yml") }
