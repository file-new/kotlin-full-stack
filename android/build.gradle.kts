plugins {
    id("com.android.application")
    id("kotlin-android")
}

repositories {
    google()
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

dependencies {
    implementation(project(":shared"))

    implementation(Deps.kotlinJvm)
    implementation(Deps.Android.appCompat)
    implementation(Deps.Android.contraintLayout)
    implementation(Deps.Android.lifecyleExtensions)
    implementation(Deps.Android.lifecyleRuntime)
    implementation(Deps.Android.material)

    testImplementation(Deps.junit)

    androidTestImplementation(Deps.Android.testRunner)
}