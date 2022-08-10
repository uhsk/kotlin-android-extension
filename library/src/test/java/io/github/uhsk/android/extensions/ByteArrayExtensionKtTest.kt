package io.github.uhsk.android.extensions

import org.junit.Assert
import org.junit.Test

class ByteArrayExtensionKtTest {

    @Test
    fun md5() {
        val test: ByteArray = "test".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals("098F6BCD4621D373CADE4E832627B4F6", test.md5())
    }

    @Test
    fun toHexString() {
        val test: ByteArray = "test".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals(test.toHexString(), "74657374")
        Assert.assertEquals(test.md5(), "098F6BCD4621D373CADE4E832627B4F6")
    }

    @Test
    fun sha1() {
        val test: ByteArray = "test".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals("A94A8FE5CCB19BA61C4C0873D391E987982FBBD3", test.sha1())
    }

    @Test
    fun sha256() {
        val test: ByteArray = "test".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals("9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08", test.sha256())
    }

    @Test
    fun sha512() {
        val test: ByteArray = "test".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals("EE26B0DD4AF7E749AA1A8EE3C10AE9923F618980772E473F8819A5D4940E0DB27AC185F8A0E1D5F84F88BC887FD67B143732C304CC5FA9AD8E6F57F50028A8FF", test.sha512())
    }
}
