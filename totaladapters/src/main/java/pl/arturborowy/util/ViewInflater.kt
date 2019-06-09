package pl.arturborowy.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

internal class ViewInflater {

    @Throws(ClassCastException::class)
    fun <ViewT : View> inflateToType(@LayoutRes layoutResId: Int,
                                     parent: ViewGroup,
                                     attachToRoot: Boolean = false) =
            inflate(layoutResId, parent, attachToRoot) as ViewT

    fun inflate(@LayoutRes layoutResId: Int,
                parent: ViewGroup,
                attachToRoot: Boolean = false): View =
            LayoutInflater.from(parent.context).inflate(layoutResId, parent, attachToRoot)
}