package pl.arturborowy

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

internal object TestServiceLocator {

    fun init(context: Context, vararg mockModules: Module) {
        val applicationContext = context.applicationContext

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(mockModules.asIterable())
        }
    }
}