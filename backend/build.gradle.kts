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
            implementation(kotlin(Deps.Kotlin.Jvm.stdLib))
            implementation(Deps.Jvm.ktorServer)
            implementation(project(":shared"))
        }
    }
    getByName("test") {
        dependencies {
            implementation(kotlin(Deps.Kotlin.Jvm.stdLib))
            implementation(kotlin(Deps.Kotlin.Jvm.junit))
            implementation(project(":shared"))
        }
    }
}