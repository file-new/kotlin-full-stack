plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

repositories {
    google()
    jcenter()
    mavenCentral()
}

android {
    compileSdkVersion(28)

    defaultConfig {
        minSdkVersion(15)
        targetSdkVersion(28)
    }
    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/androidMain/kotlin")
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
        }
    }
}

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    iosX64("ios") {
        binaries {
            framework("shared")
        }
    }
    jvm()
    js {
        browser {
            testTask {}
        }
        nodejs {
            testTask {
                testLogging {
                    showExceptions = true
                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
                    showCauses = true
                    showStackTraces = true
                }
            }
        }
    }

    @Suppress("UNUSED_VARIABLE") // The name of the some properties are used to look up the source set.
    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(Deps.Kotlin.Common.coroutines)
                implementation(kotlin(Deps.Kotlin.Common.stdLib))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Common.test))
                implementation(kotlin(Deps.Kotlin.Common.testAnnotations))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Android.stdLib))
            }
        }

        val androidTest by getting {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Android.junit))
            }
        }

        val iosMain by getting {
            dependencies {}
        }

        val iosTest by getting {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Common.test))
                implementation(kotlin(Deps.Kotlin.Common.testAnnotations))
            }
        }

        jvm().compilations["main"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Jvm.stdLib))
            }
        }

        jvm().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Jvm.junit))
            }
        }


        js().compilations["main"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Js.stdLib))
            }
        }

        js().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Js.test))
            }
        }
    }
}

configurations.create("compileClasspath")

// Pull in iOS specific tasks
apply(from = "iosTasks.gradle")