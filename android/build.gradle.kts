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

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("androidx.appcompat:appcompat:${Versions.androidx}")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.android.material:material:${Versions.androidx}")

    testImplementation("junit:junit:4.12")

    androidTestImplementation("androidx.test:runner:1.1.1")
}