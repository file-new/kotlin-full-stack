package fnew

import fnew.shared.Platform
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class SampleTest {
    @Test
    fun sanityTest() {
        assertEquals(expected = "JVM", actual = Platform.name)
    }
}