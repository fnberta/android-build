import com.github.fnberta.kotlinbuild.configureDetekt
import com.github.fnberta.kotlinbuild.configureKotlin

plugins {
    kotlin("android")
    id("com.github.fnberta.kotlinbuild.spotless")
}

configureKotlin()

configureDetekt()
