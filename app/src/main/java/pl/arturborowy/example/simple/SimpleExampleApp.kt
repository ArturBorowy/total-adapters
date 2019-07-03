package pl.arturborowy.example.simple

import android.app.Application
import pl.arturborowy.TotalAdapters

class SimpleExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        TotalAdapters.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        TotalAdapters.destroy()
    }
}