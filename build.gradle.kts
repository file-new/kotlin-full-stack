buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
//        classpath("com.android.tools.build:gradle:${Versions.agp}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}