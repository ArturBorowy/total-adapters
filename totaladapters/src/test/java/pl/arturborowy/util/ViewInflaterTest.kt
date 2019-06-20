package pl.arturborowy.util

import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.test.R

@RunWith(RobolectricTestRunner::class)
internal class ViewInflaterTest {

    private val viewInflater = ViewInflater()

    private val context = TestData.getContext()

    @Test
    fun `inflateToType with same ViewT as givenLayout's top view type calls inflate with same arguments`() {
        val givenLayoutResId = R.layout.view
        val givenParent: ViewGroup = mock()
        val givenAttachToRoot = true

        given(givenParent.context).willReturn(context)

        val spyViewInflater = spy(viewInflater)

        spyViewInflater.inflateToType<TextView>(givenLayoutResId, givenParent, givenAttachToRoot)

        Mockito.verify(spyViewInflater, Mockito.times(1))
                .inflate(givenLayoutResId, givenParent, givenAttachToRoot)
    }

    @Test(expected = ClassCastException::class)
    fun `inflateToType with same ViewT as givenLayout's top view type throws ClassCastException`() {
        val givenLayoutResId = R.layout.view
        val givenParent: ViewGroup = mock()
        val givenAttachToRoot = true

        given(givenParent.context).willReturn(context)

        val actualView = viewInflater.inflateToType<ImageView>(givenLayoutResId, givenParent, givenAttachToRoot)
    }

    @Test
    fun `inflate returns view with same type as givenLayout's top view (TextView)`() {
        val givenLayoutResId = R.layout.view
        val givenParent = FrameLayout(context)

        val inflateView = viewInflater.inflate(givenLayoutResId, givenParent)

        Assert.assertTrue(inflateView is TextView)
    }

    @Test
    fun `inflate returns view with type as givenLayout's top view (LinearLayout)`() {
        val givenLayoutResId = R.layout.notification_action
        val givenParent = FrameLayout(context)

        val inflateView = viewInflater.inflate(givenLayoutResId, givenParent)

        Assert.assertTrue(inflateView is LinearLayout)
    }

    @Test
    fun `inflate returns view with children matching givenLayout children`() {
        val givenLayoutResId = R.layout.notification_action
        val givenParent = FrameLayout(context)

        val inflateView = viewInflater.inflate(givenLayoutResId, givenParent) as ViewGroup

        assertHasNotificationActionChildren(inflateView)
    }

    private fun assertHasNotificationActionChildren(viewGroup: ViewGroup) {
        Assert.assertNotEquals(null, viewGroup.findViewById(R.id.action_image))

        Assert.assertNotEquals(null, viewGroup.findViewById(R.id.action_text))
    }
}