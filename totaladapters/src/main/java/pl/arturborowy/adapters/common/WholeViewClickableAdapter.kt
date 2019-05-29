package pl.arturborowy.adapters.common

import android.view.View
import pl.arturborowy.adapters.ViewStylist

internal interface WholeViewClickableAdapter<ViewT : View, ItemT> : ClickableViewAdapter<ItemT>,
        ViewStylist<ViewT, ItemT> {

    override fun styleView(view: ViewT, item: ItemT, position: Int) =
            view.setOnClickListener { onItemClickAction(item, position) }
}