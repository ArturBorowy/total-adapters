package pl.arturborowy.examples.recycler.base

import android.widget.TextView
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.R
import pl.arturborowy.examples.recyclerview.base.ExampleBaseRecyclerAdapter
import pl.arturborowy.util.TestData

@RunWith(RobolectricTestRunner::class)
class ExampleBaseRecyclerAdapterTest {

    private val context = TestData.getContext()

    private val exampleBaseRecyclerAdapter = ExampleBaseRecyclerAdapter()

    @Test
    fun `is item_text_view layout set`() =
            Assert.assertEquals(R.layout.item_text_view, exampleBaseRecyclerAdapter.getLayoutResId())

    @Test
    fun `styleView sets given item as text on given TextView`() {
        val givenView = TextView(context)
        val givenItem = "eiefjjrf23434;];{:}{:"
        val givenPosition = 0

        exampleBaseRecyclerAdapter.styleView(givenView, givenItem, givenPosition)

        Assert.assertEquals(givenItem, givenView.text)
    }
}