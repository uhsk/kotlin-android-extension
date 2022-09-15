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

import io.github.uhsk.kit.libs.codec.digest.DigestUtils
import java.util.*

/**
 * @author sollyu
 * @date   2022-08-10
 */
class ByteArrayHashUtil(private val bytes: ByteArray) {

    /**
     * @since 1.0.3
     * @author sollyu
     */
    fun uuid(): UUID = UUID.nameUUIDFromBytes(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun md2(): ByteArray = DigestUtils.md2(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun md5(): ByteArray = DigestUtils.md5(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha(): ByteArray = DigestUtils.sha1(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha1(): ByteArray = DigestUtils.sha1(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha256(): ByteArray = DigestUtils.sha256(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha3_224(): ByteArray = DigestUtils.sha3_224(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha3_256(): ByteArray = DigestUtils.sha3_256(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha3_384(): ByteArray = DigestUtils.sha3_384(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha3_512(): ByteArray = DigestUtils.sha3_512(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha384(): ByteArray = DigestUtils.sha384(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha512(): ByteArray = DigestUtils.sha512(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha512_224(): ByteArray = DigestUtils.sha512_224(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha512_256(): ByteArray = DigestUtils.sha512_256(bytes)


}
