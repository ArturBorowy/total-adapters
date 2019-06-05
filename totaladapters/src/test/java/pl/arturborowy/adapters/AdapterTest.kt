package pl.arturborowy.adapters

import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.MockTotalAdapters
import pl.arturborowy.util.TestData
import pl.arturborowy.util.ViewInflater

@RunWith(RobolectricTestRunner::class)
internal abstract class AdapterTest {

    protected val context = TestData.getContext()

    @Mock
    protected lateinit var mockViewInflater: ViewInflater

    protected val givenStrings = TestData.STRING_LIST

    @Before
    open fun setUp() {
        MockTotalAdapters.init(context, module { single { mockViewInflater } })
        MockitoAnnotations.initMocks(this)
    }

    @After
    fun tearDown() = stopKoin()
}