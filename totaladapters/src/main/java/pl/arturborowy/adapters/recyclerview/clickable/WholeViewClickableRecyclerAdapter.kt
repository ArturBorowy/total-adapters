package pl.arturborowy.adapters.recyclerview.clickable

import android.view.View
import pl.arturborowy.adapters.common.WholeViewClickableAdapter

abstract class WholeViewClickableRecyclerAdapter<ViewT : View, ItemT>(items: Collection<ItemT> =
                                                                              listOf()) :
        ClickableViewRecyclerAdapter<ViewT, ItemT>(items), WholeViewClickableAdapter<ViewT, ItemT>