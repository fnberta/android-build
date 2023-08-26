import com.github.fnberta.kotlinbuild.configureAndroid
import com.github.fnberta.kotlinbuild.configureDetekt
import com.github.fnberta.kotlinbuild.configureKotlin
import com.github.fnberta.kotlinbuild.configureSpotless

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
