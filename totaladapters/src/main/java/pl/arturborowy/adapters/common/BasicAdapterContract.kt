package pl.arturborowy.adapters.common

import android.view.View
import org.koin.core.KoinComponent
import pl.arturborowy.adapters.HasLayoutResId
import pl.arturborowy.adapters.ViewStylist

internal interface BasicAdapterContract<ItemT, ViewT : View> :
        HasLayoutResId, ViewStylist<ViewT, ItemT>, KoinComponent, UpdateItemsAdapter<ItemT>