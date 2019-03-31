import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilationToRunnableFiles

plugins {
    application
    kotlin("multiplatform") version Versions.kotlin
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js()
    sourceSets {
        @Suppress("UNUSED_VARIABLE") // The name of the property is used to look up the source set.
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }

        @Suppress("UNUSED_VARIABLE") // The name of the property is used to look up the source set.
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        // Default source set for JVM-specific sources and dependencies:
        jvm().compilations["main"].defaultSourceSet {
            application {
                mainClassName = "fnew.MainKt"
            }
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(Deps.ktorServer)
            }
        }
        // JVM-specific tests and their dependencies:
        jvm().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        // JS-specific tests and their dependencies:
        js().compilations["main"].defaultSourceSet {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        // JVM-specific tests and their dependencies:
        js().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

fun getJvmClasses() : ConfigurableFileCollection {
    val target = kotlin.targets.getByName("jvm")
    val compilation = target.compilations.getByName("main") as KotlinCompilationToRunnableFiles<KotlinCommonOptions>
    return files(
        compilation.runtimeDependencyFiles,
        compilation.output.allOutputs
    )
}


tasks.named<JavaExec>("run") {
    main = "fnew.MainKt"
    classpath = getJvmClasses()
}
