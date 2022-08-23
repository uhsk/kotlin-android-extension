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

class MapExtensionKtTest {


    @Test
    fun getOrDefault() {
        val hashMap: HashMap<String, String?> = HashMap()
        hashMap["test1"] = null
        Assert.assertEquals(null, hashMap.getOrDefault(key = "test1", default = ""))
        Assert.assertEquals(null, hashMap.getOrDefault(key = "test2", default = null))
        Assert.assertEquals("", hashMap.getOrDefault(key = "test2", default = ""))
    }

    @Test
    fun getOrDefaultNotNull() {
        val hashMap: HashMap<String, String?> = HashMap()
        hashMap["test1"] = null
        Assert.assertEquals("", hashMap.getOrDefaultNotNull(key = "test1", default = ""))
    }

    @Test
    fun getValueAs() {
        val hashMap: HashMap<String, Any?> = HashMap()
        hashMap["test1"] = null
        hashMap["test2"] = 1
        hashMap["test3"] = ""

        val test1Value: Any? = hashMap.getValueAs(key = "test1")
        Assert.assertEquals(null, test1Value)

        val test2Value: Int = hashMap.getValueAs(key = "test2")
        Assert.assertEquals(1, test2Value)

        val test3Value: String = hashMap.getValueAs(key = "test3")
        Assert.assertEquals("", test3Value)
    }
}
