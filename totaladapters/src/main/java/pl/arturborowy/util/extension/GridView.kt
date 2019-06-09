package pl.arturborowy.util.extension

import android.widget.BaseAdapter
import android.widget.GridView
import pl.arturborowy.adapters.common.interfaces.UpdateItemsAdapter
import timber.log.Timber

fun GridView.setAdapter(updateItemsAdapter: UpdateItemsAdapter<*>) {
    try {
        adapter = updateItemsAdapter as BaseAdapter
    } catch (exception: ClassCastException) {
        Timber.e("Tried to call gridView.setAdapter(...) with incorrect adapter type. ")
    }
}