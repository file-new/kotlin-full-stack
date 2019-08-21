buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:${Versions.androidGradlePlugin}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.create("ciTest") {
    dependsOn(
        "shared:jvmTest",
        "shared:jsTest",
        "backend:test",
        "android:test"
    )
}