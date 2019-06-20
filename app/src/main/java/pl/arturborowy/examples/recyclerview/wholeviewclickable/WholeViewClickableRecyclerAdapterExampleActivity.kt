package pl.arturborowy.examples.recyclerview.wholeviewclickable

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recycler.*
import pl.arturborowy.R
import pl.arturborowy.adapters.common.interfaces.ClickableViewAdapter
import pl.arturborowy.util.extension.setAdapter

class WholeViewClickableRecyclerAdapterExampleActivity : AppCompatActivity() {

    private val adapter: ClickableViewAdapter<String> = ExampleWholeViewClickableRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        initList()
    }

    private fun initList() {
        adapter.setOnItemClickListener { item, position -> onItemClick(item, position) }

        list.setAdapter(adapter)

        adapter.updateItems(getItems())
    }

    private fun getItems() = resources.getStringArray(R.array.strings).toList()

    private fun onItemClick(item: String, position: Int) =
            Toast.makeText(this, "$position. $item.", Toast.LENGTH_SHORT).show()
}