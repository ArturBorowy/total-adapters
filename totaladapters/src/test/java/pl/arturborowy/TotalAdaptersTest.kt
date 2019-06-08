package pl.arturborowy

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.util.TestData

@RunWith(RobolectricTestRunner::class)
internal class TotalAdaptersTest {

    private val context = TestData.getContext()

    @After
    fun tearDown() = stopKoin()

    @Test(expected = KoinAppAlreadyStartedException::class)
    fun `init starts Koin, so next init throws KoinAppAlreadyStartedException`() {
        TotalAdapters.init(context)
        TotalAdapters.init(context)
    }

    @Test
    fun `destroy stops Koin, so next init doesn't throw KoinAppAlreadyStartedException`() {
        TotalAdapters.init(context)

        TotalAdapters.destroy()

        TotalAdapters.init(context)
    }
}