package sample

import fnew.hello
import org.junit.Assert
import org.junit.Test

class SampleTestsAndroid {
    @Test
    fun testHello() {
        Assert.assertTrue("Android" in hello())
    }
}