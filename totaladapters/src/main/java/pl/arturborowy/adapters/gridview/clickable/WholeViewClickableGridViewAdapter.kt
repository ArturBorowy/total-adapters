package pl.arturborowy.adapters.gridview.clickable

import android.view.View
import pl.arturborowy.adapters.common.contracts.WholeClickableViewStylist

abstract class WholeViewClickableGridViewAdapter<ViewT : View, ItemT>(
        items: Collection<ItemT> = listOf()) :
        ClickableViewGridViewAdapter<ViewT, ItemT>(items), WholeClickableViewStylist<ViewT, ItemT>