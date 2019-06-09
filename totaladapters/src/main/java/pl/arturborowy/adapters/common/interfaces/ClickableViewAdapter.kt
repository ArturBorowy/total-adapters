package pl.arturborowy.adapters.common.interfaces

interface ClickableViewAdapter<ItemT> : UpdateItemsAdapter<ItemT> {

    fun setOnItemClickListener(onItemClickAction: (ItemT, Int) -> Unit)
}