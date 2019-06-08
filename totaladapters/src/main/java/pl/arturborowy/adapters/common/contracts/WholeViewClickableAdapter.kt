package pl.arturborowy.adapters.common.contracts

import android.view.View
import pl.arturborowy.adapters.ViewStylist

internal interface WholeViewClickableAdapter<ViewT : View, ItemT> : OnItemListenerHolder<ItemT>,
        ViewStylist<ViewT, ItemT> {

    override fun styleView(view: ViewT, item: ItemT, position: Int) =
            view.setOnClickListener { onItemClickAction(item, position) }
}