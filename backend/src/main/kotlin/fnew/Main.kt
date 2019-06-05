package fnew

import fnew.shared.hello
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    hello()
    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText(hello(), ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}
