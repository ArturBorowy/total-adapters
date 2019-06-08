package pl.arturborowy.adapters.common

interface BasicAdapter<ItemT> {

    fun updateItems(items: Collection<ItemT>)
}