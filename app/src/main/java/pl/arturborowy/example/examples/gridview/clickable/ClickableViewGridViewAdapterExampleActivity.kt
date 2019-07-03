package pl.arturborowy.example.examples.gridview.clickable

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_grid_view.*
import pl.arturborowy.adapters.common.interfaces.ClickableViewAdapter
import pl.arturborowy.example.R
import pl.arturborowy.util.extension.setAdapter

class ClickableViewGridViewAdapterExampleActivity : AppCompatActivity() {

    private val adapter: ClickableViewAdapter<String> = ExampleClickableViewGridViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        initGridView()
    }

    private fun initGridView() {
        gridView.setAdapter(adapter)

        adapter.updateItems(getItems())
        adapter.setOnItemClickListener { item, position -> onItemClick(item, position) }
    }

    private fun getItems() = resources.getStringArray(R.array.strings).toList()

    private fun onItemClick(item: String, position: Int) =
            Toast.makeText(this, "$position. $item.", Toast.LENGTH_SHORT).show()
}