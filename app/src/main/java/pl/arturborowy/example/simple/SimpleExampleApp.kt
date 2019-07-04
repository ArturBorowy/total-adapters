package pl.arturborowy.example.simple

import android.app.Application
import pl.arturborowy.TotalAdapters
import pl.arturborowy.example.BuildConfig

class SimpleExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        TotalAdapters.init(this, BuildConfig.DEBUG)
    }

    override fun onTerminate() {
        super.onTerminate()
        TotalAdapters.destroy()
    }
}