package pl.arturborowy.example.util

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider

object TestData {

    fun getContext(): Context = ApplicationProvider.getApplicationContext<Application>()
}