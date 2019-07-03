package pl.arturborowy.example.selector

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_example_selector.*
import org.jetbrains.anko.startActivity
import pl.arturborowy.example.R
import pl.arturborowy.example.examples.gridview.base.BaseGridViewAdapterExampleActivity
import pl.arturborowy.example.examples.gridview.clickable.ClickableViewGridViewAdapterExampleActivity
import pl.arturborowy.example.examples.gridview.wholeviewclickable.WholeViewClickableGridViewAdapterExampleActivity
import pl.arturborowy.example.examples.recyclerview.base.BaseRecyclerAdapterExampleActivity
import pl.arturborowy.example.examples.recyclerview.clickable.ClickableViewRecyclerAdapterExampleActivity
import pl.arturborowy.example.examples.recyclerview.wholeviewclickable.WholeViewClickableRecyclerAdapterExampleActivity

class ExampleSelectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_selector)

        showExampleBtn.setOnClickListener { showExample() }
    }

    private fun showExample() {
        val isRecyclerViewChecked = recyclerViewRadio.isChecked
        val isGridViewChecked = gridViewRadio.isChecked

        val isBaseChecked = baseAdapterRadio.isChecked
        val isClickableViewChecked = clickableViewAdapterRadio.isChecked
        val isWholeViewClickableChecked = wholeViewClickableAdapterRadio.isChecked

        when {
            isRecyclerViewChecked -> showRecyclerViewExample(isBaseChecked,
                    isClickableViewChecked, isWholeViewClickableChecked)
            isGridViewChecked -> showGridViewExample(isBaseChecked,
                    isClickableViewChecked, isWholeViewClickableChecked)
        }
    }

    private fun showRecyclerViewExample(isBaseChecked: Boolean,
                                        isClickableViewChecked: Boolean,
                                        isWholeViewClickableChecked: Boolean) {
        when {
            isBaseChecked -> startActivity<BaseRecyclerAdapterExampleActivity>()
            isClickableViewChecked ->
                startActivity<ClickableViewRecyclerAdapterExampleActivity>()
            isWholeViewClickableChecked ->
                startActivity<WholeViewClickableRecyclerAdapterExampleActivity>()
        }
    }

    private fun showGridViewExample(isBaseChecked: Boolean,
                                    isClickableViewChecked: Boolean,
                                    isWholeViewClickableChecked: Boolean) {
        when {
            isBaseChecked -> startActivity<BaseGridViewAdapterExampleActivity>()
            isClickableViewChecked ->
                startActivity<ClickableViewGridViewAdapterExampleActivity>()
            isWholeViewClickableChecked ->
                startActivity<WholeViewClickableGridViewAdapterExampleActivity>()
        }
    }
}