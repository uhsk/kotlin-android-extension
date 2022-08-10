package io.github.uhsk.android.extensions.utils

import android.util.Base64
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.uhsk.android.extensions.base64
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinExtensionBase64Test {
    @Test
    fun encode() {
        val testTarget: ByteArray = "test".toByteArray(charset = Charsets.UTF_8)
        Assert.assertArrayEquals(testTarget.base64().encode(), byteArrayOf(100, 71, 86, 122, 100, 65, 61, 61, 10))
    }

    @Test
    fun encodeToString() {
        val testTarget: ByteArray = "test".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals(testTarget.base64().encodeToString(), "dGVzdA==\n")
        Assert.assertEquals(testTarget.base64().encodeToString(flags = Base64.NO_WRAP), "dGVzdA==")
    }

    @Test
    fun decode() {
        val testTarget: ByteArray = "dGVzdA==".toByteArray(charset = Charsets.UTF_8)
        Assert.assertArrayEquals(testTarget.base64().decode(), byteArrayOf(116, 101, 115, 116))
    }
}
