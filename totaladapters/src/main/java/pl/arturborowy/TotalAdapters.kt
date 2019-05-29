package pl.arturborowy

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import pl.arturborowy.util.ViewInflater

object TotalAdapters {

    fun init(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context.applicationContext)
            modules(applicationModule)
        }
    }

    private val applicationModule = module { single { ViewInflater() } }
}