import com.github.fnberta.kotlinbuild.TARGET_SDK
import com.github.fnberta.kotlinbuild.configureAndroid
import com.github.fnberta.kotlinbuild.configureDetekt
import com.github.fnberta.kotlinbuild.configureKotlin

plugins {
    kotlin("android")
    id("com.android.application")
    id("com.github.fnberta.kotlinbuild.spotless")
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

configureDetekt()
