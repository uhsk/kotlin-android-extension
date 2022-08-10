package io.github.uhsk.kit

import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

/**
 * @author ethan
 * @since 1.0.2
 * @date 2022年8月10日
 */
class LongExtensionKtTest {

    @Test
    fun toDate() {
        val date = 1660143400589L.toDate()
        Assert.assertEquals(date.format(), "2022-08-10 22:56:40")
    }

}