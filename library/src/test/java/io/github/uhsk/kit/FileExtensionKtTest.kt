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
import java.io.File

class FileExtensionKtTest {

    @Test
    fun join() {
        Assert.assertEquals(File("/sdcard/Android/data").join(paths = arrayOf("com.android.settings", "files")).path, "/sdcard/Android/data/com.android.settings/files")
        Assert.assertEquals(File("/sdcard/Android/data/").join(paths = arrayOf("com.android.settings/", "files")).path, "/sdcard/Android/data/com.android.settings/files")
        Assert.assertEquals(File("/sdcard/Android/data/").join(paths = arrayOf("com.android.settings/", "..")).path, "/sdcard/Android/data")
    }

    @Test
    fun pathDirectory() {
        Assert.assertEquals(File("/sdcard/Android/data/com.android.settings/files/cache.log").pathDirectory, "/sdcard/Android/data/com.android.settings/files/")
    }

    @Test
    fun pathDirectoryNoEndSeparator() {
        Assert.assertEquals(File("/sdcard/Android/data/com.android.settings/files/cache.log").pathDirectoryNoEndSeparator, "/sdcard/Android/data/com.android.settings/files")
    }

    @Test
    fun isExtension() {
        Assert.assertEquals(File("/sdcard/cache.log").isExtension(extension = "log"), true)
        Assert.assertEquals(File("/sdcard/cache.log").isExtension(extension = "txt"), false)
        Assert.assertEquals(File("/sdcard/cache.log").isExtension(extension = arrayOf("txt", "log")), true)
        Assert.assertEquals(File("/sdcard/cache.log").isExtension(extension = arrayOf("txt", "mp3")), false)
    }

    @Test
    fun pathNormalize() {
        Assert.assertEquals(File("/sdcard/remove/../cache.log").pathNormalize, "/sdcard/cache.log")
    }

    @Test
    fun pathRemoveExtension() {
        Assert.assertEquals(File("/sdcard/cache.log").pathRemoveExtension, "/sdcard/cache")
    }


}
