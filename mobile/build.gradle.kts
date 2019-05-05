import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilationToRunnableFiles

plugins {
    kotlin("multiplatform")
    id("com.android.application")
}

repositories {
    mavenCentral()
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "fnew.fnew"
        minSdkVersion(15)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

kotlin {
    android("android")
    // Switch here to iosArm64 (or iosArm32) to build library for iPhone device
    iosX64("ios") {
        binaries {
            framework()
        }
    }
    sourceSets {
        @Suppress("UNUSED_VARIABLE") // The name of the property is used to look up the source set.
        val androidMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("androidx.appcompat:appcompat:${Versions.androidx}")
                implementation("androidx.constraintlayout:constraintlayout:1.1.3")
                implementation("com.google.android.material:material:${Versions.androidx}")

                implementation(project(":shared"))
            }
        }
        @Suppress("UNUSED_VARIABLE") // The name of the property is used to look up the source set.
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
//        // iOS
//        ios().compilations["main"].defaultSourceSet {
//        }
//        // iOS Test
//        ios().compilations["test"].defaultSourceSet {
//        }
    }
}

// This task attaches native framework built from ios module to Xcode project
// (see iosApp directory). Don't run this task directly,
// Xcode runs this task itself during its build process.
// Before opening the project from iosApp directory in Xcode,
// make sure all Gradle infrastructure exists (gradle.wrapper, gradlew).
//task("copyFramework") {
//    val buildType = project.findProperty("kotlin.build.type") ?: "DEBUG"
//    val target = project.findProperty("kotlin.target") ?: "ios"
//    dependsOn(kotlin.targets."$target".binaries.getFramework(buildType).linkTask
//
//    doLast {
//        val srcFile = kotlin.targets."$target".binaries.getFramework(buildType).outputFile
//        val targetDir = getProperty('configuration.build.dir')
//        copy {
//            from srcFile.parent
//                    into targetDir
//                    include 'app.framework/**'
//            include 'app.framework.dSYM'
//        }
//    }
//}