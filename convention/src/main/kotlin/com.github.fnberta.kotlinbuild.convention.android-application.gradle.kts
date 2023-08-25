import com.github.fnberta.kotlinbuild.convention.TARGET_SDK
import com.github.fnberta.kotlinbuild.convention.configureAndroid
import com.github.fnberta.kotlinbuild.convention.configureDetekt
import com.github.fnberta.kotlinbuild.convention.configureKotlin
import com.github.fnberta.kotlinbuild.convention.configureSpotless

plugins {
    kotlin("android")
    id("com.android.application")
    id("com.diffplug.spotless")
    id("io.gitlab.arturbosch.detekt")
}

android {
    configureAndroid(this)

    defaultConfig { targetSdk = TARGET_SDK }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }

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
