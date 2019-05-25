package pl.arturborowy.adapters

import androidx.annotation.LayoutRes

interface HasLayoutResId {

    @LayoutRes
    fun getLayoutResId(): Int
}