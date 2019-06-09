package pl.arturborowy.extensions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.R
import pl.arturborowy.adapters.AdapterTest
import pl.arturborowy.adapters.common.interfaces.UpdateItemsAdapter
import pl.arturborowy.adapters.recyclerview.base.BaseRecyclerAdapter
import pl.arturborowy.util.extension.setAdapter

@RunWith(RobolectricTestRunner::class)
internal class RecyclerViewSetAdapterTest : AdapterTest() {

    private val recyclerView = RecyclerView(context)

    @Test
    fun `setAdapter sets adapter if given adapter has correct type`() {
        val correctTypeAdapter: UpdateItemsAdapter<String> = getBaseRecyclerAdapter()

        recyclerView.setAdapter(correctTypeAdapter)

        Assert.assertEquals(correctTypeAdapter, recyclerView.adapter)
    }

    private fun getBaseRecyclerAdapter() =
            object : BaseRecyclerAdapter<View, String>(givenStrings) {
                override fun styleView(view: View, item: String, position: Int) {}

                override fun getLayoutResId() = R.layout.view
            }

    @Test
    fun `setAdapter doesn't set adapter if given adapter has incorrect type`() {
        val incorrectTypeAdapter = object : UpdateItemsAdapter<String> {
            override fun updateItems(items: Collection<String>) {}
        }

        recyclerView.setAdapter(incorrectTypeAdapter)

        Assert.assertEquals(null, recyclerView.adapter)
    }
}