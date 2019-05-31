package fnew

import org.junit.Test
import kotlin.test.assertTrue

class SampleTestsAndroid {
    @Test
    fun testHello() {
        assertTrue { "Android" in hello() }
    }
}