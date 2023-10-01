import com.github.fnberta.kotlinbuild.configureJvmKotlin

plugins {
    kotlin("jvm")
    id("com.github.fnberta.kotlinbuild.spotless")
    id("com.github.fnberta.kotlinbuild.detekt")
}

configureJvmKotlin()
