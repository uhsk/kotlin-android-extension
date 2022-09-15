/*
 * Copyright (C) 2022. sollyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.uhsk.kit

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

    @Test
    fun aesCbcPKCS5Padding() {
        val key: ByteArray = "1234567890123456".toByteArray()
        val iv: ByteArray = "1234567890123456".toByteArray()
        val test: ByteArray = "hello world".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals("6C0C78D1E15455FFE12316DA57CFC669", test.crypto().aesCbcPKCS5Padding().encrypt(key, iv).toHexString())
        Assert.assertEquals("hello world", "6C0C78D1E15455FFE12316DA57CFC669".asHexStringToByteArray().crypto().aesCbcPKCS5Padding().decrypt(key, iv).toString(charset = Charsets.UTF_8))
    }

    @Test
    fun aesCbcNoPadding() {
        val key: ByteArray = "1234567890123456".toByteArray()
        val iv: ByteArray = "1234567890123456".toByteArray()
        val test: ByteArray = "HelloWorldKotlin".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals("0C64EAD1B08AAAA383D557D7D8D16258", test.crypto().aesCbcNoPadding().encrypt(key, iv).toHexString())
        Assert.assertEquals("HelloWorldKotlin", "0C64EAD1B08AAAA383D557D7D8D16258".asHexStringToByteArray().crypto().aesCbcNoPadding().decrypt(key, iv).toString(charset = Charsets.UTF_8))
    }

    @Test
    fun aesEbcPKCS5Padding() {
        val key: ByteArray = "1234567890123456".toByteArray()
        val test: ByteArray = "hello world".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals("AE82F34F7181855430DB65AB50F01DB3", test.crypto().aesEbcPKCS5Padding().encrypt(key).toHexString())
        Assert.assertEquals("hello world", "AE82F34F7181855430DB65AB50F01DB3".asHexStringToByteArray().crypto().aesEbcPKCS5Padding().decrypt(key).toString(charset = Charsets.UTF_8))
    }

    @Test
    fun aesEbcNoPadding() {
        val key: ByteArray = "1234567890123456".toByteArray()
        val test: ByteArray = "HelloWorldKotlin".toByteArray(charset = Charsets.UTF_8)
        Assert.assertEquals("EADBC09B3B1C2F5FF90900386895339A", test.crypto().aesEbcNoPadding().encrypt(key).toHexString())
        Assert.assertEquals("HelloWorldKotlin", "EADBC09B3B1C2F5FF90900386895339A".asHexStringToByteArray().crypto().aesEbcNoPadding().decrypt(key).toString(charset = Charsets.UTF_8))
    }

    @Test
    fun align() {
        Assert.assertArrayEquals(byteArrayOf(0x00), byteArrayOf().align(length = 1, byte = 0x00))
        Assert.assertArrayEquals(byteArrayOf(0x00, 0x00), byteArrayOf(0x00, 0x00).align(length = 1, byte = 0x00))
        Assert.assertArrayEquals(byteArrayOf(0x00.toByte(), 0x00.toByte(), 0x00.toByte(), 0x01.toByte()), byteArrayOf(0x01.toByte()).align(length = 4, byte = 0x00))
        Assert.assertArrayEquals(byteArrayOf(0xA0.toByte(), 0xA0.toByte(), 0xA0.toByte(), 0x01.toByte()), byteArrayOf(0x01.toByte()).align(length = 4, byte = 0xA0.toByte()))
    }

    @Test
    fun toInt() {
        Assert.assertEquals(0x00000000, byteArrayOf().toInt())
        Assert.assertEquals(0x00000001, byteArrayOf(0x01).toInt())
        Assert.assertEquals(0x00002F01, byteArrayOf(0x2F, 0x01).toInt())
        Assert.assertEquals(0x00002F01, byteArrayOf(0x00, 0x2F, 0x01).toInt(offset = 1))
        Assert.assertEquals(0x000E2F01, byteArrayOf(0x0E, 0x2F, 0x01).toInt())
        Assert.assertEquals(0x7F0E2F01, byteArrayOf(0x7F, 0x0E, 0x2F, 0x01).toInt())
    }

    @Test
    fun toByteBuffer() {
        Assert.assertEquals(1, byteArrayOf(0x7F).toByteBuffer().array().size)
    }
}
