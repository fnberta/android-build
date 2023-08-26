import com.github.fnberta.kotlinbuild.configureAndroid
import com.github.fnberta.kotlinbuild.configureKotlin

plugins {
    kotlin("android")
    id("com.android.library")
    id("com.github.fnberta.kotlinbuild.spotless")
    id("com.github.fnberta.kotlinbuild.detekt")
}

android {
    configureAndroid(this)

    defaultConfig { consumerProguardFiles("consumer-rules.pro") }
}

configureKotlin()
