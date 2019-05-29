plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    sourceSets {
        @Suppress("UNUSED_VARIABLE") // The name of the property is used to look up the source set.
        val commonMain by getting {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Common.stdLib))
            }
        }

        @Suppress("UNUSED_VARIABLE") // The name of the property is used to look up the source set.
        val commonTest by getting {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Common.test))
                implementation(kotlin(Deps.Kotlin.Common.testAnnotations))
            }
        }

        // Default source set for JVM-specific sources and dependencies:
        jvm().compilations["main"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Jvm.stdLib))
            }
        }
        // JVM-specific tests and their dependencies:
        jvm().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Jvm.junit))
            }
        }
    }
}