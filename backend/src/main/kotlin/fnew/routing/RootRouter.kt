package fnew.routing

import fnew.shared.Hello
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

class RootRouter: Router {
    override fun route(): Routing.() -> Unit = {
        get("/") {
            call.respond(Hello())
        }
    }
}