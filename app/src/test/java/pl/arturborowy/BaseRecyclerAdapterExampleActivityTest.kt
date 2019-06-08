package pl.arturborowy

import android.widget.TextView
import androidx.core.view.children
import androidx.test.core.app.ActivityScenario
import kotlinx.android.synthetic.main.activity_recycler.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.examples.recyclerview.base.BaseRecyclerAdapterExampleActivity
import pl.arturborowy.util.TestData

@RunWith(RobolectricTestRunner::class)
class BaseRecyclerAdapterExampleActivityTest {

    private val context = TestData.getContext()

    private val scenario = ActivityScenario.launch(BaseRecyclerAdapterExampleActivity::class.java)

    private val items = context.resources.getStringArray(R.array.strings)

    @Test
    fun `are correct items set on list`() {
        scenario.onActivity { activity ->
            val children = activity.list.children

            for (i in 0 until children.count()) {
                val child = children.elementAt(i) as TextView
                val item = items[i]

                Assert.assertEquals(item, child.text)
            }
        }
    }
}