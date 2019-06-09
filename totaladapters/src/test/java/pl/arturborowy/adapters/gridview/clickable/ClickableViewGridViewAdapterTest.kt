package pl.arturborowy.adapters.gridview.clickable

import android.widget.TextView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import pl.arturborowy.adapters.AdapterTest
import pl.arturborowy.util.EmptyMethod

internal class ClickableViewGridViewAdapterTest : AdapterTest() {

    private lateinit var adapter: ClickableViewGridViewAdapter<String, TextView>

    @Before
    override fun setUp() {
        super.setUp()
        adapter = getClickableViewGridViewAdapter()
    }

    @Test
    fun `onItemClickAction is emptyMethod by default`() =
            Assert.assertEquals(EmptyMethod.twoArguments<String, Int>(), adapter.onItemClickAction)

    private fun getClickableViewGridViewAdapter() =
            object : ClickableViewGridViewAdapter<String, TextView>() {
                override fun getLayoutResId() = TODO()

                override fun styleView(view: TextView, item: String, position: Int) =
                        TODO()
            }
}