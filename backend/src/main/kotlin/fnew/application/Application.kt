package fnew.application

import fnew.di.DependencyInjection
import fnew.routing.RootRouter
import fnew.routing.addRouter
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.serialization.serialization
import org.koin.ktor.ext.Koin

fun Application.main() {
    printStartupMessage()

    setupDependencyInjection()
    setupContentNegotiation()
    setupRouters()
}

fun Application.printStartupMessage() {
    println("Starting server on http://localhost:$port")
}

@Suppress("EXPERIMENTAL_API_USAGE")
private val Application.port
    get() = environment.config.propertyOrNull("ktor.deployment.port")?.getString()

private fun Application.setupDependencyInjection() {
    install(Koin) {
        val di = DependencyInjection()
        modules(di.modules)
    }
}

private fun Application.setupContentNegotiation() {
    install(ContentNegotiation) {
//        serialization(json = json.createJson())
        serialization()
    }
}

private fun Application.setupRouters() {
    addRouter<RootRouter>()
}