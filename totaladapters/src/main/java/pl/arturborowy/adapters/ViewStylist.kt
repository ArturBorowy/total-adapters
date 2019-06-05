package pl.arturborowy.adapters

import android.view.View

internal interface ViewStylist<ViewT : View, ItemT> {

    fun styleView(view: ViewT, item: ItemT, position: Int)
}