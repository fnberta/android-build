import com.github.fnberta.kotlinbuild.configureKotlin

plugins {
    kotlin("android")
    id("com.github.fnberta.kotlinbuild.spotless")
    id("com.github.fnberta.kotlinbuild.detekt")
}

configureKotlin()
