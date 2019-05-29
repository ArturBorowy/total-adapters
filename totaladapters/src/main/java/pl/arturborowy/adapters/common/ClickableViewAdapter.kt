package pl.arturborowy.adapters.common

internal interface ClickableViewAdapter<ItemT> {

    var onItemClickAction: (ItemT, Int) -> Unit

    fun setOnItemClickListener(onItemClickAction: (ItemT, Int) -> Unit) {
        this.onItemClickAction = onItemClickAction
    }
}