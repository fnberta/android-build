package com.github.fnberta.kotlinbuild

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

const val TARGET_SDK = 34
private const val MIN_SDK = 26

internal fun Project.configureAndroid(commonExtension: CommonExtension<*, *, *, *, *>) {
    commonExtension.apply {
        compileSdk = TARGET_SDK
        defaultConfig {
            minSdk = MIN_SDK
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }
}
