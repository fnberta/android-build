import ch.berta.fabio.androidbuild.convention.configureAndroid
import ch.berta.fabio.androidbuild.convention.configureDetekt
import ch.berta.fabio.androidbuild.convention.configureKotlin
import ch.berta.fabio.androidbuild.convention.configureSpotless

plugins {
    kotlin("android")
    id("com.android.library")
    id("com.diffplug.spotless")
    id("io.gitlab.arturbosch.detekt")
}

android {
    configureAndroid(this)
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

configureKotlin()
configureSpotless()
configureDetekt()

