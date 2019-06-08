package pl.arturborowy.adapters.gridview.base

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.koin.core.inject
import pl.arturborowy.adapters.common.BasicAdapterContract
import pl.arturborowy.util.ViewInflater

abstract class BaseGridViewAdapter<ItemT, ViewT : View>(private var items: Collection<ItemT> =
                                                                listOf()) :
        BaseAdapter(), BasicAdapterContract<ItemT, ViewT> {

    private val viewInflater: ViewInflater by inject()

    override fun getCount() = items.size

    override fun getItemId(position: Int): Long = 0

    override fun getItem(position: Int) = items.elementAt(position)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = (convertView ?: createNewView(parent)) as ViewT

        val item = getItem(position)

        try {
            styleView(view, item, position)
        } catch (classCastException: ClassCastException) {
            view = createNewView(parent) as ViewT
            styleView(view, item, position)
        }

        return view
    }

    private fun createNewView(parent: ViewGroup) = viewInflater.inflate(getLayoutResId(), parent)

    override fun updateItems(items: Collection<ItemT>) {
        this.items = items
        notifyDataSetChanged()
    }
}