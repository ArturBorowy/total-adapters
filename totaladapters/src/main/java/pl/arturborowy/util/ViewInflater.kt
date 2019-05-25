package pl.arturborowy.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

class ViewInflater {

    fun inflate(@LayoutRes layoutResId: Int, parent: ViewGroup, attachToRoot: Boolean = false): View =
            LayoutInflater.from(parent.context).inflate(layoutResId, parent, attachToRoot)
}