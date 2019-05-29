package pl.arturborowy

import android.content.Context
import org.koin.core.module.Module

object MockTotalAdapters {

    fun init(context: Context, mockModule: Module) {
        TotalAdapters.applicationModule = mockModule
        TotalAdapters.init(context)
    }
}