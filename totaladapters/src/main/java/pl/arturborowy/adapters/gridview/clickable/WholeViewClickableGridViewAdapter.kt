package pl.arturborowy.adapters.gridview.clickable

import android.view.View
import pl.arturborowy.adapters.common.contracts.WholeViewClickableAdapter

internal abstract class WholeViewClickableGridViewAdapter<ViewT : View, ItemT>(
        items: Collection<ItemT> = listOf()) :
        ClickableViewGridViewAdapter<ViewT, ItemT>(items), WholeViewClickableAdapter<ViewT, ItemT>