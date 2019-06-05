package pl.arturborowy.examples.recyclerview.clickable

import android.view.View
import kotlinx.android.synthetic.main.item_with_info.view.*
import pl.arturborowy.R
import pl.arturborowy.adapters.recyclerview.clickable.ClickableViewRecyclerAdapter

class ExampleClickableViewRecyclerAdapter : ClickableViewRecyclerAdapter<View, String>() {

    override fun getLayoutResId() = R.layout.item_with_info

    override fun styleView(view: View, item: String, position: Int) {
        view.apply {
            label.text = item

            infoIcon.setOnClickListener { onItemClickAction(item, position) }
        }
    }
}