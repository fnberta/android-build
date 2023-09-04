import com.github.fnberta.kotlinbuild.configureKotlin

plugins {
    kotlin("jvm")
    id("com.github.fnberta.kotlinbuild.spotless")
    id("com.github.fnberta.kotlinbuild.detekt")
}

configureKotlin()
