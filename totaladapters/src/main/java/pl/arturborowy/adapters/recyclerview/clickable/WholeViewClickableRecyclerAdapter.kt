package pl.arturborowy.adapters.recyclerview.clickable

import android.view.View
import pl.arturborowy.util.ViewInflater

abstract class WholeViewClickableRecyclerAdapter<ViewT : View, ItemT>(viewInflater: ViewInflater,
                                                                      items: Collection<ItemT> =
                                                                              listOf()) :
        ClickableViewRecyclerAdapter<ViewT, ItemT>(viewInflater, items) {

    override fun styleView(view: ViewT, item: ItemT, position: Int) =
            view.setOnClickListener { onItemClickAction(item, position) }
}