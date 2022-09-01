package io.github.uhsk.kit

import org.junit.Assert
import org.junit.Test

/**
 * @author ethan
 * @since 1.0.2
 * @date 2022年8月10日
 */
class LongExtensionKtTest {

    @Test
    fun toDate() {
        Assert.assertEquals(1660143400589L, 1660143400589L.toDate().time)
    }

}