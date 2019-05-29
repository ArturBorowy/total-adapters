package pl.arturborowy.adapters.gridview.clickable

import android.view.View
import pl.arturborowy.adapters.common.ClickableViewAdapter
import pl.arturborowy.adapters.recyclerview.base.BaseRecyclerAdapter
import pl.arturborowy.util.EmptyMethod

internal abstract class ClickableViewGridViewAdapter<ViewT : View, ItemT>(items: Collection<ItemT> =
                                                                                  listOf()) :
        BaseRecyclerAdapter<ViewT, ItemT>(items), ClickableViewAdapter<ItemT> {

    override var onItemClickAction: (ItemT, Int) -> Unit = EmptyMethod.twoArguments()
}