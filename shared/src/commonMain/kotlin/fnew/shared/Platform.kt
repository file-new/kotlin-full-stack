package fnew.shared

import kotlinx.serialization.Serializable

expect object Platform {
    val name: String
}

@Serializable
data class Hello(val message: String = "Hello world")
