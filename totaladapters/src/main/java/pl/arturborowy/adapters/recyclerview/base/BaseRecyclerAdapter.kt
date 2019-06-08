package pl.arturborowy.adapters.recyclerview.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.koin.core.KoinComponent
import org.koin.core.inject
import pl.arturborowy.adapters.HasLayoutResId
import pl.arturborowy.adapters.ViewStylist
import pl.arturborowy.adapters.common.UpdateItemsAdapter
import pl.arturborowy.adapters.recyclerview.ViewHolder
import pl.arturborowy.util.ViewInflater

abstract class BaseRecyclerAdapter<ViewT : View, ItemT>(private var items: Collection<ItemT> =
                                                                listOf()) :
        RecyclerView.Adapter<ViewHolder>(),
        HasLayoutResId,
        ViewStylist<ViewT, ItemT>,
        KoinComponent,
        UpdateItemsAdapter<ItemT> {

    private val viewInflater: ViewInflater by inject()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = viewInflater.inflate(getLayoutResId(), parent) as ViewT
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            styleView(holder.itemView as ViewT, items.elementAt(position), position)

    override fun getItemCount() = items.size

    override fun updateItems(items: Collection<ItemT>) {
        this.items = items
        notifyDataSetChanged()
    }
}