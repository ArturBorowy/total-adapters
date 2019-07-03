package pl.arturborowy.example.examples.recyclerview.wholeviewclickable

import android.widget.TextView
import pl.arturborowy.adapters.recyclerview.clickable.WholeViewClickableRecyclerAdapter
import pl.arturborowy.example.R

class ExampleWholeViewClickableRecyclerAdapter :
        WholeViewClickableRecyclerAdapter<TextView, String>() {

    override fun getLayoutResId() = R.layout.item_text_view

    override fun styleView(view: TextView, item: String, position: Int) {
        super.styleView(view, item, position)
        view.text = item
    }
}