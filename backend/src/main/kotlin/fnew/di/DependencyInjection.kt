package fnew.di

import fnew.routing.RouterModules
import fnew.shared.SharedModules

class DependencyInjection {
    val modules = listOf(
        SharedModules(),
        RouterModules()
    ).flatMap { it.modules }
}