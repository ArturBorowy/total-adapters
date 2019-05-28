package pl.arturborowy.adapters

import androidx.annotation.LayoutRes

internal interface HasLayoutResId {

    @LayoutRes
    fun getLayoutResId(): Int
}