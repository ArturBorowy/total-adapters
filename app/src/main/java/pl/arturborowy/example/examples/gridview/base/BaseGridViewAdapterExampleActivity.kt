package pl.arturborowy.example.examples.gridview.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_grid_view.*
import pl.arturborowy.adapters.common.interfaces.UpdateItemsAdapter
import pl.arturborowy.example.R
import pl.arturborowy.util.extension.setAdapter

class BaseGridViewAdapterExampleActivity : AppCompatActivity() {

    private val adapter: UpdateItemsAdapter<String> = ExampleBaseGridViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        initGridView()
    }

    private fun initGridView() {
        gridView.setAdapter(adapter)

        adapter.updateItems(getItems())
    }

    private fun getItems() = resources.getStringArray(R.array.strings).toList()
}