package pl.arturborowy.adapters.gridview.clickable

import android.view.View
import pl.arturborowy.adapters.common.contracts.OnItemListenerHolder
import pl.arturborowy.adapters.gridview.base.BaseGridViewAdapter
import pl.arturborowy.util.EmptyMethod

abstract class ClickableViewGridViewAdapter<ItemT, ViewT : View>(items: Collection<ItemT> =
                                                                         listOf()) :
        BaseGridViewAdapter<ItemT, ViewT>(items), OnItemListenerHolder<ItemT> {

    override var onItemClickAction: (ItemT, Int) -> Unit = EmptyMethod.twoArguments()
}