package pl.arturborowy.examples.recyclerview.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recycler.*
import pl.arturborowy.R
import pl.arturborowy.adapters.common.interfaces.UpdateItemsAdapter
import pl.arturborowy.util.extension.setAdapter

class BaseRecyclerAdapterExampleActivity : AppCompatActivity() {

    private val adapter: UpdateItemsAdapter<String> = ExampleBaseRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        initList()
    }

    private fun initList() {
        list.setAdapter(adapter)

        adapter.updateItems(getItems())
    }

    private fun getItems() = resources.getStringArray(R.array.strings).toList()
}