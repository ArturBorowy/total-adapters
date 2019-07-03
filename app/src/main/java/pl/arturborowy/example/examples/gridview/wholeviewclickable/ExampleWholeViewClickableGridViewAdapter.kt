package pl.arturborowy.example.examples.gridview.wholeviewclickable

import android.widget.TextView
import pl.arturborowy.adapters.gridview.clickable.WholeViewClickableGridViewAdapter
import pl.arturborowy.example.R

class ExampleWholeViewClickableGridViewAdapter :
        WholeViewClickableGridViewAdapter<String, TextView>() {

    override fun getLayoutResId() = R.layout.item_text_view

    override fun styleView(view: TextView, item: String, position: Int) {
        super.styleView(view, item, position)
        view.text = item
    }
}