package pl.arturborowy.util.extension

import androidx.recyclerview.widget.RecyclerView
import pl.arturborowy.adapters.common.interfaces.UpdateItemsAdapter
import timber.log.Timber

fun RecyclerView.setAdapter(updateItemsAdapter: UpdateItemsAdapter<*>) {
    try {
        adapter = updateItemsAdapter as RecyclerView.Adapter<*>
    } catch (exception: ClassCastException) {
        Timber.e("Tried to call recyclerView.setAdapter(...) with incorrect adapter type. ")
    }
}
