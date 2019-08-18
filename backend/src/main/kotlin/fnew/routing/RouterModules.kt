package fnew.routing

import fnew.di.DependencyModules
import org.koin.core.module.Module
import org.koin.dsl.module

class RouterModules: DependencyModules {
    override val modules: List<Module>
        get() = listOf(routerModule())

    private fun routerModule() = module {
        single { RootRouter() }
    }
}