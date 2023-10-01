plugins {
    id("com.github.ben-manes.versions")
    id("nl.littlerobots.version-catalog-update")
}

tasks {
    dependencyUpdates {
        val immaturityLevels =
            listOf("rc", "cr", "m", "beta", "alpha", "preview").map {
                ".*[.\\-]$it[.\\-\\d]*".toRegex(RegexOption.IGNORE_CASE)
            }

        fun getImmaturityLevel(version: String): Int =
            immaturityLevels.indexOfLast { version.matches(it) }

        rejectVersionIf {
            getImmaturityLevel(candidate.version) > getImmaturityLevel(currentVersion)
        }
    }
}
