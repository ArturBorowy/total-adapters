package pl.arturborowy.examples.recyclerview.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pl.arturborowy.R

class BaseRecyclerAdapterExampleActivity : AppCompatActivity() {

    private val adapter = ExampleBaseRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
    }

    private fun initList() {
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        adapter.updateItems(getItems())
    }

    private fun getItems() = resources.getStringArray(R.array.strings)
}