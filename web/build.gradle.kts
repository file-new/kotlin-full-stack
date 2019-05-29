import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilationToRunnableFiles

plugins {
    application
    kotlin("multiplatform")
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
                project(":shared")
            }
        }

        @Suppress("UNUSED_VARIABLE") // The name of the property is used to look up the source set.
        val commonTest by getting {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Common.test))
                implementation(kotlin(Deps.Kotlin.Common.testAnnotations))
                implementation(project(":shared"))
            }
        }
        // Default source set for JVM-specific sources and dependencies:
        jvm().compilations["main"].defaultSourceSet {
            application {
                mainClassName = "fnew.MainKt"
            }
            dependencies {
                implementation(kotlin(Deps.Kotlin.Jvm.stdLib))
                implementation(Deps.Jvm.ktorServer)
                implementation(project(":shared"))
            }
        }
        // JVM-specific tests and their dependencies:
        jvm().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Jvm.junit))
            }
        }
        // JS-specific tests and their dependencies:
        js().compilations["main"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Js.stdLib))
            }
        }
        // JVM-specific tests and their dependencies:
        js().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin(Deps.Kotlin.Js.junit))
            }
        }
    }
}

// Workaround for multi-platform run task bug. See https://youtrack.jetbrains.com/issue/KT-26885
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
