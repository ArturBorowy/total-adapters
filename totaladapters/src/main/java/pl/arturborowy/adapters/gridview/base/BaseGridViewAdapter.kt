package pl.arturborowy.adapters.gridview.base

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.koin.core.KoinComponent
import org.koin.core.inject
import pl.arturborowy.adapters.HasLayoutResId
import pl.arturborowy.adapters.ViewStylist
import pl.arturborowy.util.ViewInflater

abstract class BaseGridViewAdapter<ItemT, ViewT : View>(private var items: Collection<ItemT> =
                                                                listOf()) :
        BaseAdapter(), HasLayoutResId, ViewStylist<ViewT, ItemT>, KoinComponent {

    private val viewInflater: ViewInflater by inject()

    override fun getCount() = items.size

    override fun getItemId(position: Int): Long = 0

    override fun getItem(position: Int) = items.elementAt(position)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = (convertView ?: createNewView(parent)) as ViewT
        styleView(view, getItem(position), position)
        return view
    }

    private fun createNewView(parent: ViewGroup) = viewInflater.inflate(getLayoutResId(), parent)

    fun updateItems(items: Collection<ItemT>) {
        this.items = items
        notifyDataSetChanged()
    }
}