package pl.arturborowy.adapters.recyclerview.base

import android.view.View
import android.widget.FrameLayout
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.R
import pl.arturborowy.adapters.recyclerview.ViewHolder
import pl.arturborowy.util.TestData
import pl.arturborowy.util.ViewInflater

@RunWith(RobolectricTestRunner::class)
class BaseRecyclerAdapterTest {

    private val context = TestData.getContext()

    @Mock
    private lateinit var mockViewInflater: ViewInflater

    private val givenStrings = TestData.STRING_LIST

    private lateinit var adapter: BaseRecyclerAdapter<View, String>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        adapter = getBaseRecyclerAdapter()
    }

    @Test
    fun `onCreateViewHolder returns ViewHolder with correct itemView`() {
        val spyAdapter = spy(adapter)

        val givenParent = FrameLayout(context)
        val inflatedView = View(context)

        given(mockViewInflater.inflate(spyAdapter.getLayoutResId(), givenParent))
                .willReturn(inflatedView)

        val actualViewHolder = spyAdapter.onCreateViewHolder(givenParent, 0)

        Assert.assertEquals(inflatedView, actualViewHolder.itemView)
    }

    @Test
    fun `onBindViewHolder calls styleView with correct arguments`() {
        val spyAdapter = spy(adapter)

        val givenViewHolder = ViewHolder(View(context))
        val givenPosition = 2

        spyAdapter.onBindViewHolder(givenViewHolder, givenPosition)

        Mockito.verify(spyAdapter, Mockito.times(1))
                .styleView(givenViewHolder.itemView, givenStrings[givenPosition], givenPosition)
    }

    @Test
    fun `itemCount returns items size`() {
        Assert.assertEquals(givenStrings.size, adapter.itemCount)
    }

    @Test
    fun `updateItems calls notifyDataSetChanged`() {
        adapter = spy(adapter)

        adapter.updateItems(givenStrings)

        Mockito.verify(adapter, Mockito.times(1))
                .notifyDataSetChanged()
    }

    private fun getBaseRecyclerAdapter(): BaseRecyclerAdapter<View, String> {
        return object : BaseRecyclerAdapter<View, String>(givenStrings) {
            override fun styleView(view: View, item: String, position: Int) {}

            override fun getLayoutResId() = R.layout.support_simple_spinner_dropdown_item
        }
    }
}