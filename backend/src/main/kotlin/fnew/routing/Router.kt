package fnew.routing

import io.ktor.application.Application
import io.ktor.routing.Routing
import io.ktor.routing.routing
import org.koin.core.parameter.ParametersDefinition
import org.koin.ktor.ext.inject

interface Router {
    fun route(): Routing.() -> Unit
}

inline fun <reified T : Router> Application.addRouter(noinline parameters: ParametersDefinition? = null) {
    val router by inject<T>(parameters = parameters)
    routing(router.route())
}