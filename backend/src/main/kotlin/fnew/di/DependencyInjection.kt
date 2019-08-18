package fnew.di

import fnew.routing.RouterModules
import fnew.di.shared.SharedModules

class DependencyInjection {
    val modules = listOf(
        SharedModules(),
        RouterModules()
    ).flatMap { it.modules }
}