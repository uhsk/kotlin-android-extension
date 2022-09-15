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

import io.github.uhsk.kit.libs.codec.binary.Hex
import io.github.uhsk.kit.utils.ByteArrayBase64Util
import io.github.uhsk.kit.utils.ByteArrayCryptoUtil
import io.github.uhsk.kit.utils.ByteArrayGzipUtil
import io.github.uhsk.kit.utils.ByteArrayHashUtil
import java.nio.ByteBuffer

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.md5(toLowerCase: Boolean = false): CharSequence = this.hash().md5().toHexString(toLowerCase)

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.sha1(toLowerCase: Boolean = false): CharSequence = this.hash().sha1().toHexString(toLowerCase)

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.sha256(toLowerCase: Boolean = false): CharSequence = this.hash().sha256().toHexString(toLowerCase)

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.sha512(toLowerCase: Boolean = false): CharSequence = this.hash().sha512().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.base64(): ByteArrayBase64Util = ByteArrayBase64Util(bytes = this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.hash(): ByteArrayHashUtil = ByteArrayHashUtil(bytes = this)

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.toHexString(toLowerCase: Boolean = false): CharSequence = Hex.encodeHexString(this, toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.gzip(): ByteArrayGzipUtil = ByteArrayGzipUtil(bytes = this)

/**
 * @since 1.0.8
 * @author sollyu
 */
fun ByteArray.crypto(): ByteArrayCryptoUtil = ByteArrayCryptoUtil(bytes = this)

/**
 * 将数组长度对齐。
 *
 * ```kotlin
 *  byteArrayOf(0x01).align(length = 4, byte = 0x00) == byteArrayOf(0x00, 0x00, 0x00, 0x01)
 * ```
 * @since 1.0.9
 * @author sollyu
 */
fun ByteArray.align(length: Int, byte: Byte = 0x00): ByteArray {
    var temp: ByteArray = byteArrayOf()
    for (i in size until length) {
        temp += byte
    }
    return temp + this
}

/**
 * @since 1.0.9
 * @author sollyu
 */
fun ByteArray.toInt(offset: Int = 0): Int {
    val temp: ByteArray = when (this.size - offset) {
        0    -> return 0
        1    -> byteArrayOf(0, 0, 0) + this
        2    -> byteArrayOf(0, 0) + this
        3    -> byteArrayOf(0) + this
        else -> this
    }
    return ByteBuffer.wrap(temp, offset, Int.SIZE_BYTES).int
}

/**
 * @since 1.0.9
 * @author sollyu
 */
fun ByteArray.toByteBuffer(offset: Int = 0, length: Int = this.size): ByteBuffer {
    return ByteBuffer.wrap(this, offset, length)
}
