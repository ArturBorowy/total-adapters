package pl.arturborowy.adapters.common.contracts

import android.view.View
import android.view.ViewGroup
import org.koin.core.KoinComponent
import pl.arturborowy.adapters.HasLayoutResId
import pl.arturborowy.adapters.ViewStylist
import pl.arturborowy.exceptions.AdapterViewTypeMismatchException
import pl.arturborowy.adapters.common.interfaces.UpdateItemsAdapter
import pl.arturborowy.util.ViewInflater

internal interface BasicAdapterContract<ItemT, ViewT : View> :
        HasLayoutResId, ViewStylist<ViewT, ItemT>, KoinComponent, UpdateItemsAdapter<ItemT> {

    var items: Collection<ItemT>

    val notifyDataSetChanged: () -> Unit

    override fun updateItems(items: Collection<ItemT>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun createNewView(viewInflater: ViewInflater, parent: ViewGroup) =
            try {
                viewInflater.inflateToType<ViewT>(getLayoutResId(), parent)
            } catch (exception: ClassCastException) {
                throw AdapterViewTypeMismatchException()
            }

    fun getItemAt(position: Int) = items.elementAt(position)

    fun getItemCount() = items.count()

    fun styleView(view: ViewT, position: Int) = styleView(view, getItemAt(position), position)
}