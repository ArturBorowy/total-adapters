package pl.arturborowy.adapters.recyclerview.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.koin.core.inject
import pl.arturborowy.adapters.common.contracts.BasicAdapterContract
import pl.arturborowy.adapters.recyclerview.ViewHolder
import pl.arturborowy.util.ViewInflater

abstract class BaseRecyclerAdapter<ViewT : View, ItemT>(override var items: Collection<ItemT> =
                                                                listOf()) :
        RecyclerView.Adapter<ViewHolder>(), BasicAdapterContract<ItemT, ViewT> {

    override val notifyDataSetChanged = { notifyDataSetChanged() }

    private val viewInflater: ViewInflater by inject()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = createNewView(viewInflater, parent)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            styleView(holder.itemView as ViewT, position)
}