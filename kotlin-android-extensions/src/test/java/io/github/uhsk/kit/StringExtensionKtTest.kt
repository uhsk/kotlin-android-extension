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

internal class StringExtensionKtTest {

    @Test
    fun uuid() {
        Assert.assertEquals("4fba3bc0-2b72-3e9a-a87a-1e5286e373c6", "kotlin".uuid(charset = Charsets.UTF_8))
    }

    @Test
    fun md5() {
        Assert.assertEquals("4FBA3BC02B72EE9A687A1E5286E373C6", "kotlin".md5(charset = Charsets.UTF_8))
        Assert.assertEquals("4FBA3BC02B72EE9A687A1E5286E373C6", "kotlin".md5(charset = Charsets.UTF_8, toLowerCase = false))
        Assert.assertEquals("4fba3bc02b72ee9a687a1e5286e373c6", "kotlin".md5(charset = Charsets.UTF_8, toLowerCase = true))
    }

    @Test
    fun sha1() {
        Assert.assertEquals("63D4C084C6FF9EF737AE0142C064A1E356D1D2F1", "kotlin".sha1(charset = Charsets.UTF_8))
        Assert.assertEquals("63D4C084C6FF9EF737AE0142C064A1E356D1D2F1", "kotlin".sha1(charset = Charsets.UTF_8, toLowerCase = false))
        Assert.assertEquals("63d4c084c6ff9ef737ae0142c064a1e356d1d2f1", "kotlin".sha1(charset = Charsets.UTF_8, toLowerCase = true))
    }

    @Test
    fun sha256() {
        Assert.assertEquals("19A67C2A53695668E4916E9E64CF0613352EC614FD682A8BF8BF98A471DB5E8D", "kotlin".sha256(charset = Charsets.UTF_8))
        Assert.assertEquals("19A67C2A53695668E4916E9E64CF0613352EC614FD682A8BF8BF98A471DB5E8D", "kotlin".sha256(charset = Charsets.UTF_8, toLowerCase = false))
        Assert.assertEquals("19a67c2a53695668e4916e9e64cf0613352ec614fd682a8bf8bf98a471db5e8d", "kotlin".sha256(charset = Charsets.UTF_8, toLowerCase = true))
    }

    @Test
    fun sha512() {
        Assert.assertEquals("6FE7D71FE594EBEBA6AE1757A49963478C29622CFAAD0F2B2B907A1ADF8EE4672825BA5B0DB92D84C51503F5568FC62946CB403B677DAA4504C5D9FC27E2AC10", "kotlin".sha512(charset = Charsets.UTF_8))
        Assert.assertEquals("6FE7D71FE594EBEBA6AE1757A49963478C29622CFAAD0F2B2B907A1ADF8EE4672825BA5B0DB92D84C51503F5568FC62946CB403B677DAA4504C5D9FC27E2AC10", "kotlin".sha512(charset = Charsets.UTF_8, toLowerCase = false))
        Assert.assertEquals("6fe7d71fe594ebeba6ae1757a49963478c29622cfaad0f2b2b907a1adf8ee4672825ba5b0db92d84c51503f5568fc62946cb403b677daa4504c5d9fc27e2ac10", "kotlin".sha512(charset = Charsets.UTF_8, toLowerCase = true))
    }

    @Test
    fun asFile() {
        Assert.assertEquals(("/sdcard/kotlin.txt" as CharSequence).toFile().path, "/sdcard/kotlin.txt")
    }

    @Test
    fun asHexStringToByteArray() {
        Assert.assertArrayEquals(byteArrayOf(0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F), "000102030405060708090A0B0C0D0E0F".asHexStringToByteArray())
    }

    @Test
    fun find() {
        val match: MatchResult = "kotlin 1.4.0".find(regex = Regex(pattern = "([\\d|.]+)")) ?: throw IllegalStateException()
        Assert.assertEquals("1.4.0", match.groupValues[1])
    }

    @Test
    fun toLocale() {
        Assert.assertEquals("zh_CN".toLocale().toString(), "zh_CN")
    }

    @Test
    fun toDate() {
        Assert.assertEquals("2022-09-01 11:09:46".toDate()?.time, 1662001786000)
    }
}