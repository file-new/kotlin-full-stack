object Versions {
    const val androidGradlePlugin = "3.2.0"
    const val androidLifecycle = "2.0.0"
    const val junit = "4.12"
    const val kotlin = "1.3.30"
    const val ktor = "1.1.3"
}

object Deps {
    const val junit = "junit:junit:${Versions.junit}"
    const val kotlinJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    object Android {
        const val appCompat = "androidx.appcompat:appcompat:1.0.2"
        const val contraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val lifecyleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidLifecycle}"
        const val lifecyleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.androidLifecycle}"
        const val material = "com.google.android.material:material:1.0.0"
        const val testRunner = "androidx.test:runner:1.1.1"
    }

    object Jvm {
        const val ktorServer = "io.ktor:ktor-server-netty:${Versions.ktor}"
    }

    object Kotlin {
        object Common {
            const val stdLib = "stdlib-common"
            const val test = "test-common"
            const val testAnnotations = "test-annotations-common"
        }

        object Jvm {
            const val stdLib = "stdlib-jdk8"
            const val junit = "test-junit"
        }

        object Js {
            const val stdLib = "stdlib-js"
            const val junit = "test-js"
        }
    }
}
