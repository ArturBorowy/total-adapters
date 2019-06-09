package pl.arturborowy.adapters.gridview.clickable

import android.view.View
import pl.arturborowy.adapters.common.contracts.WholeClickableViewStylist

abstract class WholeViewClickableGridViewAdapter<ItemT, ViewT : View>(
        items: Collection<ItemT> = listOf()) :
        ClickableViewGridViewAdapter<ItemT, ViewT>(items), WholeClickableViewStylist<ViewT, ItemT>