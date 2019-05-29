package pl.arturborowy.adapters.common

import android.view.View
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.adapters.AdapterTest

internal class WholeViewClickableAdapterTest : AdapterTest() {

    private lateinit var adapter: WholeViewClickableAdapter<View, String>

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
            object : WholeViewClickableAdapter<View, String> {
                override var onItemClickAction: (String, Int) -> Unit = { _: String, _: Int -> }
            }

    class ClassWithMethod {

        fun method(string: String, position: Int) {}
    }
}