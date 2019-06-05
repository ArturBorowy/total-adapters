package pl.arturborowy.adapters.recyclerview.base

import android.view.View
import android.widget.FrameLayout
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.R
import pl.arturborowy.adapters.AdapterTest
import pl.arturborowy.adapters.recyclerview.ViewHolder

internal class BaseRecyclerAdapterTest : AdapterTest() {

    private lateinit var spyAdapter: BaseRecyclerAdapter<View, String>

    @Before
    override fun setUp() {
        super.setUp()
        spyAdapter = spy(getBaseRecyclerAdapter())
    }

    @Test
    fun `onCreateViewHolder returns ViewHolder with correct itemView`() {
        val givenParent = FrameLayout(context)
        val inflatedView = View(context)

        given(mockViewInflater.inflate(spyAdapter.getLayoutResId(), givenParent))
                .willReturn(inflatedView)

        val actualViewHolder = spyAdapter.onCreateViewHolder(givenParent, 0)

        Assert.assertEquals(inflatedView, actualViewHolder.itemView)
    }

    @Test
    fun `onBindViewHolder calls styleView with correct arguments`() {
        val spyAdapter = spy(spyAdapter)

        val givenViewHolder = ViewHolder(View(context))
        val givenPosition = 2

        spyAdapter.onBindViewHolder(givenViewHolder, givenPosition)

        Mockito.verify(spyAdapter, Mockito.times(1))
                .styleView(givenViewHolder.itemView, givenStrings[givenPosition], givenPosition)
    }

    @Test
    fun `itemCount returns items size`() {
        Assert.assertEquals(givenStrings.size, spyAdapter.itemCount)
    }

    @Test
    fun `updateItems(Collection) calls notifyDataSetChanged`() {
        spyAdapter = spy(spyAdapter)

        spyAdapter.updateItems(givenStrings)

        Mockito.verify(spyAdapter, Mockito.times(1))
                .notifyDataSetChanged()
    }

    @Test
    fun `updateItems(Array) calls notifyDataSetChanged`() {
        spyAdapter = spy(spyAdapter)

        spyAdapter.updateItems(givenStrings.toTypedArray())

        Mockito.verify(spyAdapter, Mockito.times(1))
                .notifyDataSetChanged()
    }

    private fun getBaseRecyclerAdapter(): BaseRecyclerAdapter<View, String> {
        return object : BaseRecyclerAdapter<View, String>(givenStrings) {
            override fun styleView(view: View, item: String, position: Int) {}

            override fun getLayoutResId() = R.layout.view
        }
    }
}