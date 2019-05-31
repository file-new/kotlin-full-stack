plugins {
    id("kotlin2js")
}

repositories {
    mavenCentral()
}

tasks {
    compileKotlin2Js {
        kotlinOptions.outputFile = "${projectDir}/build/web/output.js"
        kotlinOptions.moduleKind = "amd"
        kotlinOptions.sourceMap = true
    }
}

sourceSets {
    getByName("main") {
        dependencies {
            implementation(kotlin(Deps.Kotlin.Js.stdLib))
            implementation(project(":shared"))
        }
    }
    getByName("test") {
        dependencies {
            implementation(kotlin(Deps.Kotlin.Js.stdLib))
            implementation(kotlin(Deps.Kotlin.Js.test))
            implementation(project(":shared"))
        }
    }
}