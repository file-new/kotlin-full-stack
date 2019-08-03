plugins {
    application
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

sourceSets {
    getByName("main") {
        application {
            mainClassName = "fnew.MainKt"
        }
        dependencies {
            implementation(project(":shared"))

            implementation(Deps.Kotlin.Common.coroutines)
            implementation(Deps.Jvm.jacksonKotlin)
            implementation(Deps.Jvm.ktorClientOkhttp)
            implementation(Deps.Jvm.ktorHtml)
            implementation(Deps.Jvm.ktorJackson)
            implementation(Deps.Jvm.ktorServer)
            implementation(kotlin(Deps.Kotlin.Jvm.stdLib))
        }
    }
    getByName("test") {
        dependencies {
            implementation(kotlin(Deps.Kotlin.Jvm.stdLib))
            implementation(kotlin(Deps.Kotlin.Jvm.junit))
            implementation(Deps.mockk)

            implementation(project(":shared"))
        }
    }
}