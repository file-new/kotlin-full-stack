package sample

import fnew.hello
import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsAndroid {
    @Test
    fun testHello() {
        assertTrue("Android" in hello())
    }
}