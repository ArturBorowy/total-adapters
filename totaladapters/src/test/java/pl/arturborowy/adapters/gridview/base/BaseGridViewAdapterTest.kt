package pl.arturborowy.adapters.gridview.base

import android.graphics.drawable.ColorDrawable
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.R
import pl.arturborowy.adapters.AdapterTest

internal class BaseGridViewAdapterTest : AdapterTest() {

    private lateinit var adapter: BaseGridViewAdapter<String, TextView>

    @Before
    override fun setUp() {
        super.setUp()
        adapter = getBaseGridViewAdapter()
    }

    @Test
    fun `notifyDataSetChanged (object) invoke calls notifyDataSetChanged() method`() {
        adapter = spy(adapter)

        adapter.notifyDataSetChanged()

        Mockito.verify(adapter, Mockito.times(1))
                .notifyDataSetChanged()
    }

    @Test
    fun `getCount calls getItemCount`() {
        adapter = spy(adapter)

        adapter.count

        Mockito.verify(adapter, Mockito.times(1))
                .getItemCount()
    }

    @Test
    fun `getItemId returns 0 for every item`() {
        for (i in 0..givenStrings.lastIndex) {
            Assert.assertEquals(0, adapter.getItemId(i))
        }
    }

    @Test
    fun `getItem calls getItemAt with given index`() {
        adapter = spy(adapter)

        for (i in 0..givenStrings.lastIndex) {
            adapter.getItem(i)

            Mockito.verify(adapter, Mockito.times(1))
                    .getItemAt(i)
        }
    }

    @Test
    fun `getView with not null convertView return same convertView`() {
        val givenConvertView = TextView(context)
        val actualView = adapter.getView(0, givenConvertView, FrameLayout(context))
        Assert.assertEquals(givenConvertView, actualView)
    }

    @Test
    fun `getView with bad type convertView inflates view in viewInflater`() {
        val givenView = TextView(context)

        given(mockViewInflater.inflate(eq(adapter.getLayoutResId()), any(), any()))
                .willReturn(givenView)

        val badTypeConvertView = ImageView(context)
        val actualView = adapter.getView(0, badTypeConvertView, FrameLayout(context))
        Assert.assertEquals(givenView, actualView)
    }

    @Test
    fun `getView with null convertView inflates view in viewInflater`() {
        val givenView = TextView(context)

        given(mockViewInflater.inflate(eq(adapter.getLayoutResId()), any(), any()))
                .willReturn(givenView)

        val actualView = adapter.getView(0, null, FrameLayout(context))
        Assert.assertNotEquals(null, actualView)
        Assert.assertEquals(givenView, actualView)
    }

    @Test
    fun `getView with not null convertView return same convertView with same customization`() {
        val givenText = "fsadfdsfsdfsg"
        val givenColor = R.color.material_blue_grey_800

        val adapter = getBaseGridViewAdapter { view: TextView, _: String, _: Int ->
            view.text = givenText
            view.setBackgroundColor(givenColor)
        }

        val givenConvertView = TextView(context)

        val actualView =
                adapter.getView(0, givenConvertView, FrameLayout(context)) as TextView

        Assert.assertEquals(givenText, actualView.text)
        Assert.assertEquals(givenColor, (actualView.background as ColorDrawable).color)
    }

    @Test
    fun `getView with null convertView inflates view in viewInflater with same customization`() {
        val givenText = "fsadfdsfsdfsg"
        val givenColor = R.color.material_blue_grey_800

        val adapter = getBaseGridViewAdapter { view: TextView, _: String, _: Int ->
            view.text = givenText
            view.setBackgroundColor(givenColor)
        }

        given(mockViewInflater.inflate(eq(adapter.getLayoutResId()), any(), any()))
                .willReturn(TextView(context))

        val actualView =
                adapter.getView(0, null, FrameLayout(context)) as TextView

        Assert.assertNotEquals(null, actualView)
        Assert.assertEquals(givenText, actualView.text)
        Assert.assertEquals(givenColor, (actualView.background as ColorDrawable).color)
    }

    private fun getBaseGridViewAdapter(customizeInflatedView: (TextView, String, Int) -> Unit =
                                               { _: TextView, _: String, _: Int -> }) =
            object : BaseGridViewAdapter<String, TextView>(givenStrings) {
                override fun getLayoutResId() = R.layout.view

                override fun styleView(view: TextView, item: String, position: Int) =
                        customizeInflatedView(view, item, position)
            }
}