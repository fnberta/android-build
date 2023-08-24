import ch.berta.fabio.kotlinbuild.convention.configureAndroid
import ch.berta.fabio.kotlinbuild.convention.configureDetekt
import ch.berta.fabio.kotlinbuild.convention.configureKotlin
import ch.berta.fabio.kotlinbuild.convention.configureSpotless

plugins {
    kotlin("android")
    id("com.android.library")
    id("com.diffplug.spotless")
    id("io.gitlab.arturbosch.detekt")
}

android {
    configureAndroid(this)
    defaultConfig { consumerProguardFiles("consumer-rules.pro") }
}

configureKotlin()

configureSpotless()

configureDetekt()
