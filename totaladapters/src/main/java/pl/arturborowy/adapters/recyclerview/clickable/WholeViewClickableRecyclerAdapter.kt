package pl.arturborowy.adapters.recyclerview.clickable

import android.view.View
import pl.arturborowy.adapters.common.contracts.WholeClickableViewStylist

abstract class WholeViewClickableRecyclerAdapter<ViewT : View, ItemT>(items: Collection<ItemT> =
                                                                              listOf()) :
        ClickableViewRecyclerAdapter<ViewT, ItemT>(items), WholeClickableViewStylist<ViewT, ItemT>