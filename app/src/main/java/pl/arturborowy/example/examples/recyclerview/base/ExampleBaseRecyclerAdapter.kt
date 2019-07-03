package pl.arturborowy.example.examples.recyclerview.base

import android.widget.TextView
import pl.arturborowy.adapters.recyclerview.base.BaseRecyclerAdapter
import pl.arturborowy.example.R

class ExampleBaseRecyclerAdapter : BaseRecyclerAdapter<TextView, String>() {

    override fun getLayoutResId() = R.layout.item_text_view

    override fun styleView(view: TextView, item: String, position: Int) {
        view.text = item
    }
}