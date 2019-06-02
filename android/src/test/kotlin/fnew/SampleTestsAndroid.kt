package fnew

import fnew.shared.hello
import org.junit.Test
import kotlin.test.assertTrue

class SampleTestsAndroid {
    @Test
    fun testHello() {
        assertTrue { "Android" in hello() }
    }
}