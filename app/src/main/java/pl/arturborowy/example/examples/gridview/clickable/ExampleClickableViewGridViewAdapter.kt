package pl.arturborowy.example.examples.gridview.clickable

import android.view.View
import kotlinx.android.synthetic.main.item_with_info.view.*
import pl.arturborowy.adapters.gridview.clickable.ClickableViewGridViewAdapter
import pl.arturborowy.example.R

class ExampleClickableViewGridViewAdapter : ClickableViewGridViewAdapter<String, View>() {

    override fun getLayoutResId() = R.layout.item_with_info

    override fun styleView(view: View, item: String, position: Int) {
        view.apply {
            label.text = item

            infoIcon.setOnClickListener { onItemClickAction(item, position) }
        }
    }
}