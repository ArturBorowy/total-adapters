package pl.arturborowy.examples.recyclerview.wholeviewclickable

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pl.arturborowy.R

class WholeViewClickableRecyclerAdapterExampleActivity : AppCompatActivity() {

    private val adapter = ExampleWholeViewClickableRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
    }

    private fun initList() {
        adapter.setOnItemClickListener { item, position -> onItemClick(item, position) }

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        adapter.updateItems(getItems())
    }

    private fun getItems() = resources.getStringArray(R.array.strings)

    private fun onItemClick(item: String, position: Int) =
            Toast.makeText(this, "$position. $item.", Toast.LENGTH_SHORT).show()
}