package pl.arturborowy.adapters.recyclerview.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.arturborowy.adapters.HasLayoutResId
import pl.arturborowy.adapters.ViewStylist
import pl.arturborowy.adapters.recyclerview.ViewHolder
import pl.arturborowy.util.ViewInflater

abstract class BaseRecyclerAdapter<ViewT : View, ItemT>(private val viewInflater: ViewInflater,
                                                        private var items: Collection<ItemT> =
                                                                listOf()) :
        RecyclerView.Adapter<ViewHolder>(), HasLayoutResId, ViewStylist<ViewT, ItemT> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = viewInflater.inflate(getLayoutResId(), parent) as ViewT
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            styleView(holder.itemView as ViewT, items.elementAt(position), position)

    override fun getItemCount() = items.size

    fun updateItems(items: Collection<ItemT>) {
        this.items = items
        notifyDataSetChanged()
    }
}