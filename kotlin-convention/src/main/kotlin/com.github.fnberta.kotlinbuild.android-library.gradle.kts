import com.github.fnberta.kotlinbuild.configureAndroid
import com.github.fnberta.kotlinbuild.configureDetekt
import com.github.fnberta.kotlinbuild.configureKotlin

plugins {
    kotlin("android")
    id("com.android.library")
    id("com.github.fnberta.kotlinbuild.spotless")
    id("io.gitlab.arturbosch.detekt")
}

android {
    configureAndroid(this)

    defaultConfig { consumerProguardFiles("consumer-rules.pro") }
}

configureKotlin()

configureDetekt()
