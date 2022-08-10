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

import org.apache.commons.io.output.ByteArrayOutputStream
import java.io.ByteArrayInputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

/**
 * @author sollyu
 * @date   2022-08-10
 */
class ByteArrayGzipUtil(private val bytes: ByteArray) {

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun compress(): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val gzipOutputStream = GZIPOutputStream(byteArrayOutputStream)
        gzipOutputStream.write(bytes)
        gzipOutputStream.close()
        return byteArrayOutputStream.toByteArray()
    }

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun uncompress(buffSize: Int = 256): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val byteArrayInputStream = ByteArrayInputStream(bytes)
        val gzipInputStream = GZIPInputStream(byteArrayInputStream)
        val buffer = ByteArray(buffSize)
        var n: Int
        while (gzipInputStream.read(buffer).also { n = it } >= 0) {
            byteArrayOutputStream.write(buffer, 0, n)
        }
        return byteArrayOutputStream.toByteArray()
    }

}
