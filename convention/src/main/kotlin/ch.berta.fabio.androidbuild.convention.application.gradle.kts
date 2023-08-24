import ch.berta.fabio.androidbuild.convention.configureAndroid
import ch.berta.fabio.androidbuild.convention.configureDetekt
import ch.berta.fabio.androidbuild.convention.configureKotlin
import ch.berta.fabio.androidbuild.convention.configureSpotless

plugins {
    kotlin("android")
    id("com.android.application")
    id("com.diffplug.spotless")
    id("io.gitlab.arturbosch.detekt")
}

android {
    configureAndroid(this)
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

configureKotlin()

configureSpotless()

configureDetekt()
