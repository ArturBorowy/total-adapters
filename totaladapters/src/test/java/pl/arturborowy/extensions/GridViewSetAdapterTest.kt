package pl.arturborowy.extensions

import android.view.View
import android.widget.GridView
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.adapters.AdapterTest
import pl.arturborowy.adapters.common.interfaces.UpdateItemsAdapter
import pl.arturborowy.adapters.gridview.base.BaseGridViewAdapter
import pl.arturborowy.test.R
import pl.arturborowy.util.extension.setAdapter

@RunWith(RobolectricTestRunner::class)
internal class GridViewSetAdapterTest : AdapterTest() {

    private val gridView = GridView(context)

    @Test
    fun `setAdapter sets adapter if given adapter has correct type`() {
        val correctTypeAdapter: UpdateItemsAdapter<String> = getBaseGridViewAdapter()

        gridView.setAdapter(correctTypeAdapter)

        Assert.assertEquals(correctTypeAdapter, gridView.adapter)
    }

    private fun getBaseGridViewAdapter() =
            object : BaseGridViewAdapter<String, View>(givenStrings) {
                override fun styleView(view: View, item: String, position: Int) {}

                override fun getLayoutResId() = R.layout.view
            }

    @Test
    fun `setAdapter doesn't set adapter if given adapter has incorrect type`() {
        val incorrectTypeAdapter = object : UpdateItemsAdapter<String> {
            override fun updateItems(items: Collection<String>) {}
        }

        gridView.setAdapter(incorrectTypeAdapter)

        Assert.assertEquals(null, gridView.adapter)
    }
}