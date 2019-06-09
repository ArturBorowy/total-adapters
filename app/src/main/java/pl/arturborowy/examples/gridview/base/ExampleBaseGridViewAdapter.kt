package pl.arturborowy.examples.gridview.base

import android.widget.TextView
import pl.arturborowy.R
import pl.arturborowy.adapters.gridview.base.BaseGridViewAdapter

class ExampleBaseGridViewAdapter : BaseGridViewAdapter<String, TextView>() {

    override fun getLayoutResId() = R.layout.item_text_view

    override fun styleView(view: TextView, item: String, position: Int) {
        view.text = item
    }
}