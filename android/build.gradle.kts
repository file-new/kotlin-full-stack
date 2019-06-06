plugins {
    id("com.android.application")
    kotlin("android")
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "fnew.fnew.fnewappname"
        minSdkVersion(15)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled = true
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
    sourceSets {
        getByName("androidTest") {
            java.srcDirs("src/androidTest/kotlin")
        }
        getByName("main") {
            java.srcDirs("src/main/kotlin")
        }
        getByName("test") {
            java.srcDirs("src/test/kotlin")
        }
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Deps.kotlinJvm)
    implementation(Deps.Android.appCompat)
    implementation(Deps.Android.contraintLayout)
    implementation(Deps.Android.lifecyleExtensions)
    implementation(Deps.Android.lifecyleRuntime)
    implementation(Deps.Android.material)

    testImplementation(kotlin(Deps.Kotlin.Jvm.junit, Versions.kotlin))

    androidTestImplementation(Deps.Android.espresso)
    androidTestImplementation(Deps.Android.junit)
    androidTestImplementation(Deps.Android.testRunner)
}