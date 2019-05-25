package pl.arturborowy.adapters.recyclerview.clickable

import android.view.View
import pl.arturborowy.adapters.recyclerview.base.BaseRecyclerAdapter
import pl.arturborowy.util.ViewInflater

abstract class ClickableViewRecyclerAdapter<ViewT : View, ItemT>(viewInflater: ViewInflater,
                                                                 items: Collection<ItemT> =
                                                                         listOf()) :
        BaseRecyclerAdapter<ViewT, ItemT>(viewInflater, items) {

    protected var onItemClickAction: (ItemT, Int) -> Unit = { _: ItemT, _: Int -> }

    fun setOnItemClickListener(onItemClickAction: (ItemT, Int) -> Unit) {
        this.onItemClickAction = onItemClickAction
    }
}