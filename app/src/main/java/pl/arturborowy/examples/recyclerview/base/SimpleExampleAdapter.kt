package pl.arturborowy.examples.recyclerview.base

import android.widget.TextView
import pl.arturborowy.R
import pl.arturborowy.adapters.recyclerview.base.BaseRecyclerAdapter

class SimpleExampleAdapter : BaseRecyclerAdapter<TextView, String>() {

    override fun getLayoutResId() = R.layout.item_text_view

    override fun styleView(view: TextView, item: String, position: Int) {
        view.text = item
    }
}