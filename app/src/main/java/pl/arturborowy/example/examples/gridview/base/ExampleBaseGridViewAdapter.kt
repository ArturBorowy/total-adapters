package pl.arturborowy.example.examples.gridview.base

import android.widget.TextView
import pl.arturborowy.adapters.gridview.base.BaseGridViewAdapter
import pl.arturborowy.example.R

class ExampleBaseGridViewAdapter : BaseGridViewAdapter<String, TextView>() {

    override fun getLayoutResId() = R.layout.item_text_view

    override fun styleView(view: TextView, item: String, position: Int) {
        view.text = item
    }
}