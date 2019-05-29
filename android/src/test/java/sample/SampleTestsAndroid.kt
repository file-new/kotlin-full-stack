package sample

import fnew.hello

class SampleTestsAndroid {
    @Test
    fun testHello() {
        assertTrue("Android" in hello())
    }
}