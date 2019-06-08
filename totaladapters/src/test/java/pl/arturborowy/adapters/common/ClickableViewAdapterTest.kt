package pl.arturborowy.adapters.common

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import pl.arturborowy.adapters.AdapterTest
import pl.arturborowy.adapters.common.contracts.ClickableViewAdapter
import pl.arturborowy.util.EmptyMethod

internal class ClickableViewAdapterTest : AdapterTest() {

    private lateinit var adapter: ClickableViewAdapter<String>

    @Before
    override fun setUp() {
        super.setUp()
        adapter = getClickableViewAdapter()
    }

    @Test
    fun `setOnItemClickListener sets onItemClickAction`() {
        val givenOnItemClickAction: (String, Int) -> Unit = EmptyMethod.twoArguments()

        adapter.setOnItemClickListener(givenOnItemClickAction)

        Assert.assertEquals(givenOnItemClickAction, adapter.onItemClickAction)
    }

    private fun getClickableViewAdapter() =
            object : ClickableViewAdapter<String> {
                override var onItemClickAction: (String, Int) -> Unit = EmptyMethod.twoArguments()
            }
}