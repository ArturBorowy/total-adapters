package pl.arturborowy.adapters.recyclerview.clickable

import android.view.View

abstract class WholeViewClickableRecyclerAdapter<ViewT : View, ItemT>(items: Collection<ItemT> =
                                                                              listOf()) :
        ClickableViewRecyclerAdapter<ViewT, ItemT>(items) {

    override fun styleView(view: ViewT, item: ItemT, position: Int) =
            view.setOnClickListener { onItemClickAction(item, position) }
}