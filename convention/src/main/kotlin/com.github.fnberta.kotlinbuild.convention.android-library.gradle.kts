import com.github.fnberta.kotlinbuild.convention.configureAndroid
import com.github.fnberta.kotlinbuild.convention.configureDetekt
import com.github.fnberta.kotlinbuild.convention.configureKotlin
import com.github.fnberta.kotlinbuild.convention.configureSpotless

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
