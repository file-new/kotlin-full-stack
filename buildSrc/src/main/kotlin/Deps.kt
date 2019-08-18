object Versions {
    const val androidGradlePlugin = "3.2.0"
    const val androidLifecycle = "2.0.0"
    const val junit = "4.12"
    const val koin = "2.0.1"
    const val kotlin = "1.3.40"
    const val ktor = "1.2.3"
    const val serialization = "0.11.1"
}

object Deps {
    const val kotlinJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val mockk = "io.mockk:mockk:1.9.3.kotlin12"

    object Android {
        const val appCompat = "androidx.appcompat:appcompat:1.0.2"
        const val contraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.1.0"
        const val junit = "androidx.test.ext:junit:1.1.0"
        const val lifecyleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidLifecycle}"
        const val lifecyleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.androidLifecycle}"
        const val material = "com.google.android.material:material:1.0.0"
        const val testRunner = "androidx.test:runner:1.1.1"
    }

    object Jvm {
        const val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8"
        const val koinKtor = "org.koin:koin-ktor:${Versions.koin}"
        const val ktorClientOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        const val ktorHtml = "io.ktor:ktor-html-builder:${Versions.ktor}"
        const val ktorJackson = "io.ktor:ktor-jackson:${Versions.ktor}"
        const val ktorSerialization = "io.ktor:ktor-serialization:${Versions.ktor}"
        const val ktorServer = "io.ktor:ktor-server-netty:${Versions.ktor}"
    }

    object Kotlin {
        object Android {
            const val stdLib = "stdlib"
            const val junit = "test-junit"
        }

        object Common {
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0-RC"
            const val koinCore = "org.koin:koin-core:${Versions.koin}"
            const val serialization =
                "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.serialization}"
            const val stdLib = "stdlib-common"
            const val test = "test-common"
            const val testAnnotations = "test-annotations-common"
        }

        object Jvm {
            const val junit = "test-junit"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serialization}"
            const val stdLib = "stdlib-jdk8"
        }

        object Js {
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:${Versions.serialization}"
            const val stdLib = "stdlib-js"
            const val test = "test-js"
        }
    }
}