package fnew.di.shared

import fnew.di.DependencyModules
import org.koin.core.module.Module

/**
 * Dependencies from the Kotlin MPP shared module.
 */
class SharedModules : DependencyModules {
    override val modules: List<Module>
        get() = emptyList()
}