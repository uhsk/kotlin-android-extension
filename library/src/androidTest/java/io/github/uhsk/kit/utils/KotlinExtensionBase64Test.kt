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

package io.github.uhsk.kit.utils

import android.util.Base64
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.uhsk.kit.base64
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
