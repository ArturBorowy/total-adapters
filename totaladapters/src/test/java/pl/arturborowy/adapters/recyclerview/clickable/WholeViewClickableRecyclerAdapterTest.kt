package pl.arturborowy.adapters.recyclerview.clickable

import android.view.View
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.R
import pl.arturborowy.util.TestData
import pl.arturborowy.util.ViewInflater

@RunWith(RobolectricTestRunner::class)
class WholeViewClickableRecyclerAdapterTest {

    private val context = TestData.getContext()

    @Mock
    private lateinit var mockViewInflater: ViewInflater

    private val givenStrings = TestData.STRING_LIST

    private lateinit var adapter: WholeViewClickableRecyclerAdapter<View, String>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        adapter = getWholeViewClickableRecyclerAdapter()
    }

    @Test
    fun `styleView sets onClickListener on givenView`() {
        val givenView = View(context)
        val givenPosition = 1

        val mockObjectWithMethod: ClassWithMethod = mock()

        givenView.performClick()

        Mockito.verify(mockObjectWithMethod, Mockito.never())
                .method(givenStrings[givenPosition], givenPosition)

        adapter.setOnItemClickListener { string: String, position: Int ->
            mockObjectWithMethod.method(string, position)
        }

        adapter.styleView(givenView, givenStrings[givenPosition], givenPosition)

        givenView.performClick()

        Mockito.verify(mockObjectWithMethod, Mockito.times(1))
                .method(givenStrings[givenPosition], givenPosition)

        givenView.performClick()

        givenView.performClick()

        Mockito.verify(mockObjectWithMethod, Mockito.times(3))
                .method(givenStrings[givenPosition], givenPosition)
    }

    private fun getWholeViewClickableRecyclerAdapter() =
            object : WholeViewClickableRecyclerAdapter<View, String>(mockViewInflater, givenStrings) {
                override fun getLayoutResId() = R.layout.support_simple_spinner_dropdown_item
            }

    class ClassWithMethod {

        fun method(string: String, position: Int) {}
    }
}