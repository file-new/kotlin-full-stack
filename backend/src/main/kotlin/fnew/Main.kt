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
    val port = 8080
    println("Starting server on http://localhost:$port")
    embeddedServer(Netty, port) {
        routing {
            get("/") {
                call.respondText(hello(), ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}
