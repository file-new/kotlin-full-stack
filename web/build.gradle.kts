

plugins {
    id("org.jetbrains.kotlin.js")
}

repositories {
    mavenCentral()
}

kotlin {
    target {
        browser()
        useCommonJs()
    }

    sourceSets {
        getByName("main") {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Js.stdLib))
                implementation(project(":shared"))
            }
        }
        getByName("test") {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Js.stdLib))
                implementation(kotlin(Deps.Kotlin.Js.test))
                implementation(project(":shared"))
            }
        }
    }
}