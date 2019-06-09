package pl.arturborowy.adapters.common.contracts

import pl.arturborowy.adapters.common.interfaces.ClickableViewAdapter

internal interface OnItemListenerHolder<ItemT> : ClickableViewAdapter<ItemT> {

    var onItemClickAction: (ItemT, Int) -> Unit

    override fun setOnItemClickListener(onItemClickAction: (ItemT, Int) -> Unit) {
        this.onItemClickAction = onItemClickAction
    }
}