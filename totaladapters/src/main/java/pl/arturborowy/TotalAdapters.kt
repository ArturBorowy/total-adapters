package pl.arturborowy

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import pl.arturborowy.util.ViewInflater
import timber.log.Timber

object TotalAdapters {

    // Needed to replace the component with a test specific one
    internal var applicationModule = module { single { ViewInflater() } }

    fun init(context: Context, isDebug : Boolean) {
        val applicationContext = context.applicationContext

        initLogger(isDebug)
        initServiceLocator(applicationContext)
    }

    private fun initLogger(isDebug : Boolean) {
        if (isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initServiceLocator(applicationContext: Context) {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(applicationModule)
        }
    }

    fun destroy() = destroyServiceLocator()

    private fun destroyServiceLocator() = stopKoin()
}