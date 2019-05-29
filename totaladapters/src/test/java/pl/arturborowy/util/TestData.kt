package pl.arturborowy.util

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider

internal object TestData {

    val STRING_LIST = listOf("fsfsdfds", "FSDSFSDFDSF", "$#@RTtfGT$", "[pl[l}Ppl")

    fun getContext(): Context = ApplicationProvider.getApplicationContext<Application>()
}