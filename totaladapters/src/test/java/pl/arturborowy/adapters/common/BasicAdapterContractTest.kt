package pl.arturborowy.adapters.common

import android.view.ViewGroup
import android.widget.TextView
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import pl.arturborowy.R
import pl.arturborowy.exceptions.AdapterViewTypeMismatchException
import pl.arturborowy.util.TestData
import pl.arturborowy.util.ViewInflater

@RunWith(MockitoJUnitRunner::class)
class BasicAdapterContractTest {

    private lateinit var basicAdapterContract: BasicAdapterContract<String, TextView>

    private val layoutResId = R.layout.view

    private val givenItems = TestData.STRING_LIST

    @Before
    fun setUp() {
        basicAdapterContract = getBasicAdapterContract()
    }

    @Test
    fun `updateItems calls notifyDataSetChanged`() {
        basicAdapterContract.updateItems(givenItems)

        Mockito.verify(basicAdapterContract.notifyDataSetChanged, Mockito.times(1))
                .invoke()
    }

    @Test
    fun `updateItems sets items`() {
        basicAdapterContract.updateItems(givenItems)

        Assert.assertEquals(givenItems, basicAdapterContract.items)
    }

    @Test
    fun `createNewView calls inflateToType on given ViewInflater`() {
        val mockViewInflater: ViewInflater = mock()

        val givenMockParent: ViewGroup = mock()

        basicAdapterContract.createNewView(mockViewInflater, givenMockParent)

        Mockito.verify(mockViewInflater, Mockito.times(1))
                .inflateToType<TextView>(layoutResId, givenMockParent)
    }

    @Test(expected = AdapterViewTypeMismatchException::class)
    fun `createNewView throws AdapterViewTypeMismatchException when viewInflater throws ClassCastException`() {
        val mockViewInflater: ViewInflater = mock()

        val givenMockParent: ViewGroup = mock()

        given(mockViewInflater.inflateToType<TextView>(layoutResId, givenMockParent))
                .willThrow(ClassCastException())

        basicAdapterContract.createNewView(mockViewInflater, givenMockParent)
    }

    @Test
    fun `getItemAt returns item of given index`() {
        for (i in 0..givenItems.lastIndex) {
            Assert.assertEquals(givenItems[i], basicAdapterContract.getItemAt(i))
        }
    }

    @Test
    fun `getItemCount returns items size`() =
            Assert.assertEquals(givenItems.size, basicAdapterContract.getItemCount())

    @Test
    fun `styleView(ViewT, Int) calls (ViewT, ItemT, Int)`() {
        val givenMockView: TextView = mock()
        val givenPosition = 3

        basicAdapterContract = spy(basicAdapterContract)

        basicAdapterContract.styleView(givenMockView, givenPosition)

        Mockito.verify(basicAdapterContract, Mockito.times(1))
                .styleView(givenMockView, givenItems[givenPosition], givenPosition)
    }

    private fun getBasicAdapterContract() =
            object : BasicAdapterContract<String, TextView> {
                override var items: Collection<String> = givenItems

                override val notifyDataSetChanged = mock<() -> Unit>()

                override fun styleView(view: TextView, item: String, position: Int) {}

                override fun getLayoutResId() = layoutResId
            }
}