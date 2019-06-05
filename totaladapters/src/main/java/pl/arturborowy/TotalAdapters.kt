package pl.arturborowy

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import pl.arturborowy.util.ViewInflater

object TotalAdapters {

    // Needed to replace the component with a test specific one
    internal var applicationModule = module { single { ViewInflater() } }

    fun init(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context.applicationContext)
            modules(applicationModule)
        }
    }

    fun destroy() = stopKoin()
}