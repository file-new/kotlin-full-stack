package fnew.shared

import fnew.di.DependencyModules
import org.koin.core.module.Module

class SharedModules : DependencyModules {
    override val modules: List<Module>
        get() = emptyList()

//    private fun jsonModules() = module {
//        factory { SingularityJson() }
//    }
}