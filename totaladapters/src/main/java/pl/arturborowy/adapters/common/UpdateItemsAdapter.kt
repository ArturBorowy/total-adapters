package pl.arturborowy.adapters.common

interface UpdateItemsAdapter<ItemT> {

    fun updateItems(items: Collection<ItemT>)
}