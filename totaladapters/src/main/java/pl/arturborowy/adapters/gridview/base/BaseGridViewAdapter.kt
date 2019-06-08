package pl.arturborowy.adapters.gridview.base

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.koin.core.inject
import pl.arturborowy.adapters.common.BasicAdapterContract
import pl.arturborowy.util.ViewInflater

abstract class BaseGridViewAdapter<ItemT, ViewT : View>(override var items: Collection<ItemT> =
                                                                listOf()) :
        BaseAdapter(), BasicAdapterContract<ItemT, ViewT> {

    override val notifyDataSetChanged = { notifyDataSetChanged() }

    private val viewInflater: ViewInflater by inject()

    override fun getCount() = getItemCount()

    override fun getItemId(position: Int): Long = 0

    override fun getItem(position: Int) = getItemAt(position)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = (convertView ?: createNewView(viewInflater, parent)) as ViewT

        try {
            styleView(view, position)
        } catch (classCastException: ClassCastException) {
            view = createNewView(viewInflater, parent)
            styleView(view, position)
        }

        return view
    }
}