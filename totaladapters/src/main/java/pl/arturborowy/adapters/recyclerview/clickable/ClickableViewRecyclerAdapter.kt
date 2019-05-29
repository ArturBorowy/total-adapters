package pl.arturborowy.adapters.recyclerview.clickable

import android.view.View
import pl.arturborowy.adapters.common.ClickableViewAdapter
import pl.arturborowy.adapters.recyclerview.base.BaseRecyclerAdapter

abstract class ClickableViewRecyclerAdapter<ViewT : View, ItemT>(items: Collection<ItemT> =
                                                                         listOf()) :
        BaseRecyclerAdapter<ViewT, ItemT>(items), ClickableViewAdapter<ItemT> {

    override var onItemClickAction: (ItemT, Int) -> Unit = { _: ItemT, _: Int -> }
}