package pl.arturborowy.util.extension

import androidx.recyclerview.widget.RecyclerView
import pl.arturborowy.adapters.common.BasicAdapter
import timber.log.Timber

fun RecyclerView.setAdapter(basicAdapter: BasicAdapter<*>) {
    try {
        adapter = basicAdapter as RecyclerView.Adapter<*>
    } catch (exception: ClassCastException) {
        Timber.e("Tried to call recyclerView.setAdapter(...) with incorrect adapter type. ")
    }
}
