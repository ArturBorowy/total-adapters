package pl.arturborowy.adapters.common.interfaces

interface UpdateItemsAdapter<ItemT> {

    fun updateItems(items: Collection<ItemT>)
}