package fnew

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.Test
import kotlin.test.assertTrue

@RunWith(JUnit4::class)
class SampleTest {
    @Test
    fun sanity() {
        assertTrue { true }
    }
}