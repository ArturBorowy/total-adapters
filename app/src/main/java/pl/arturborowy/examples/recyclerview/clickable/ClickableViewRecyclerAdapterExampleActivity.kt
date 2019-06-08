package pl.arturborowy.examples.recyclerview.clickable

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*
import pl.arturborowy.R
import pl.arturborowy.adapters.common.interfaces.ClickableViewAdapter
import pl.arturborowy.util.extension.setAdapter

class ClickableViewRecyclerAdapterExampleActivity : AppCompatActivity() {

    private val adapter: ClickableViewAdapter<String> = ExampleClickableViewRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        initList()
    }

    private fun initList() {
        list.layoutManager = LinearLayoutManager(this)
        list.setAdapter(adapter)

        adapter.updateItems(getItems())
        adapter.setOnItemClickListener { item, position -> onItemClick(item, position) }
    }

    private fun getItems() = resources.getStringArray(R.array.strings)

    private fun onItemClick(item: String, position: Int) =
            Toast.makeText(this, "$position. $item.", Toast.LENGTH_SHORT).show()
}