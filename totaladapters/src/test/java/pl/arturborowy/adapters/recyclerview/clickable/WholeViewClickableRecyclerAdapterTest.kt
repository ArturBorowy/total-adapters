package pl.arturborowy.adapters.recyclerview.clickable

import android.view.View
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.R
import pl.arturborowy.adapters.recyclerview.RecyclerAdapterTest

internal class WholeViewClickableRecyclerAdapterTest : RecyclerAdapterTest() {

    private lateinit var adapter: WholeViewClickableRecyclerAdapter<View, String>

    @Before
    override fun setUp() {
        super.setUp()
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
            object : WholeViewClickableRecyclerAdapter<View, String>(givenStrings) {
                override fun getLayoutResId() = R.layout.view
            }

    class ClassWithMethod {

        fun method(string: String, position: Int) {}
    }
}