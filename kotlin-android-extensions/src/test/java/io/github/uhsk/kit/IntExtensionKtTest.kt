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

class IntExtensionKtTest {

    @Test
    fun toByteArray() {
        Assert.assertArrayEquals(byteArrayOf(0x00, 0x00, 0x00, 0x00), 0x00000000.toByteArray())
        Assert.assertArrayEquals(byteArrayOf(0x00, 0x00, 0x00, 0x01), 0x00000001.toByteArray())
        Assert.assertArrayEquals(byteArrayOf(0x00, 0x00, 0x23, 0x01), 0x00002301.toByteArray())
        Assert.assertArrayEquals(byteArrayOf(0x00, 0x04, 0x23, 0x01), 0x00042301.toByteArray())
        Assert.assertArrayEquals(byteArrayOf(0x7A, 0x04, 0x23, 0x01), 0x7A042301.toByteArray())
    }
}
