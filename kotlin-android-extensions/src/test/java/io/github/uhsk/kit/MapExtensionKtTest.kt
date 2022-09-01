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
        Assert.assertEquals(null, hashMap.getValueIfNotExist(key = "test1", default = ""))
        Assert.assertEquals(null, hashMap.getValueIfNotExist(key = "test2", default = null))
        Assert.assertEquals("", hashMap.getValueIfNotExist(key = "test2", default = ""))
    }

    @Test
    fun getValueIfNull() {
        val hashMap: HashMap<String, String?> = HashMap()
        hashMap["test1"] = null
        Assert.assertEquals("", hashMap.getValueIfNull(key = "test1", default = ""))
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

    @Test
    fun getValueIfEmpty() {
        val hashMap: HashMap<String, CharSequence?> = HashMap()
        hashMap["test1"] = null
        hashMap["test2"] = ""
        hashMap["test3"] = " "
        hashMap["test4"] = "1"

        Assert.assertEquals("hello", hashMap.getValueIfNullOrEmpty(key = "test0", default = "hello"))
        Assert.assertEquals("hello", hashMap.getValueIfNullOrEmpty(key = "test1", default = "hello"))
        Assert.assertEquals("hello", hashMap.getValueIfNullOrEmpty(key = "test2", default = "hello"))
        Assert.assertEquals(" ", hashMap.getValueIfNullOrEmpty(key = "test3", default = "hello"))
        Assert.assertEquals("1", hashMap.getValueIfNullOrEmpty(key = "test4", default = "hello"))
    }

    @Test
    fun getValueIfBlank() {
        val hashMap: HashMap<String, CharSequence?> = HashMap()
        hashMap["test1"] = null
        hashMap["test2"] = ""
        hashMap["test3"] = " "
        hashMap["test4"] = "1"

        Assert.assertEquals("hello", hashMap.getValueIfNullOrBlank(key = "test0", default = "hello"))
        Assert.assertEquals("hello", hashMap.getValueIfNullOrBlank(key = "test1", default = "hello"))
        Assert.assertEquals("hello", hashMap.getValueIfNullOrBlank(key = "test2", default = "hello"))
        Assert.assertEquals("hello", hashMap.getValueIfNullOrBlank(key = "test3", default = "hello"))
        Assert.assertEquals("1", hashMap.getValueIfNullOrBlank(key = "test4", default = "hello"))
    }

    @Test
    fun getValueIfPredicate() {
        val hashMap: HashMap<String, CharSequence?> = HashMap()
        hashMap["test1"] = null
        hashMap["test2"] = ""
        hashMap["test3"] = " "

        Assert.assertEquals("hello", hashMap.getValueIfNullOrPredicate(key = "test0", default = "hello") { it?.isEmpty() == true })
        Assert.assertEquals("hello", hashMap.getValueIfNullOrPredicate(key = "test1", default = "hello") { it?.isEmpty() == true })
        Assert.assertEquals("hello", hashMap.getValueIfNullOrPredicate(key = "test2", default = "hello") { it?.isBlank() == true })
        Assert.assertEquals("hello", hashMap.getValueIfNullOrPredicate(key = "test3", default = "hello") { it?.isBlank() == true })
    }
}
