package pl.arturborowy.adapters.common

import android.view.View
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.adapters.AdapterTest
import pl.arturborowy.adapters.common.contracts.WholeClickableViewStylist
import pl.arturborowy.util.EmptyMethod

internal class WholeViewClickableAdapterTest : AdapterTest() {

    private lateinit var adapter: WholeClickableViewStylist<View, String>

    @Before
    override fun setUp() {
        super.setUp()
        adapter = getWholeViewClickableAdapter()
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

    private fun getWholeViewClickableAdapter() =
            object : WholeClickableViewStylist<View, String> {
                override fun updateItems(items: Collection<String>) {
                }

                override var onItemClickAction: (String, Int) -> Unit = EmptyMethod.twoArguments()
            }

    class ClassWithMethod {

        fun method(string: String, position: Int) {}
    }
}