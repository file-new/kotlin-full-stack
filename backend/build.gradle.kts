plugins {
    application
    kotlin("jvm")
    id("kotlinx-serialization")
}

repositories {
    mavenCentral()
    jcenter()
}

sourceSets {
    getByName("main") {
        application {
            mainClassName = "io.ktor.server.netty.EngineMain"
        }
        dependencies {
            implementation(project(":shared"))

            implementation(Deps.Kotlin.Common.coroutines)
            implementation(Deps.Jvm.jacksonKotlin)
            implementation(Deps.Jvm.koinKtor)
            implementation(Deps.Jvm.ktorClientOkhttp)
            implementation(Deps.Jvm.ktorHtml)
            implementation(Deps.Jvm.ktorSerialization)
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