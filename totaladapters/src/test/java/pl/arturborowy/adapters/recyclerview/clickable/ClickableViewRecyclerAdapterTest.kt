package pl.arturborowy.adapters.recyclerview.clickable

import android.widget.TextView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import pl.arturborowy.adapters.AdapterTest
import pl.arturborowy.util.EmptyMethod

internal class ClickableViewRecyclerAdapterTest : AdapterTest() {

    private lateinit var adapter: ClickableViewRecyclerAdapter<TextView, String>

    @Before
    override fun setUp() {
        super.setUp()
        adapter = getClickableViewRecyclerAdapter()
    }

    @Test
    fun `onItemClickAction is emptyMethod by default`() =
            Assert.assertEquals(EmptyMethod.twoArguments<String, Int>(), adapter.onItemClickAction)

    private fun getClickableViewRecyclerAdapter() =
            object : ClickableViewRecyclerAdapter<TextView, String>() {
                override fun getLayoutResId() = TODO()

                override fun styleView(view: TextView, item: String, position: Int) =
                        TODO()
            }
}