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

import io.github.uhsk.kit.libs.codec.digest.DigestUtils
import org.apache.commons.io.IOUtils
import java.io.InputStream
import java.nio.charset.Charset

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.md2(): ByteArray = DigestUtils.md2(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.md5(): ByteArray = DigestUtils.md5(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
@Suppress(names = ["DEPRECATION"])
@Deprecated(message = "", replaceWith = ReplaceWith(expression = "sha1()"))
fun InputStream.sha(): ByteArray = DigestUtils.sha(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha1(): ByteArray = DigestUtils.sha1(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha256(): ByteArray = DigestUtils.sha256(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha3_224(): ByteArray = DigestUtils.sha3_224(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha3_256(): ByteArray = DigestUtils.sha3_256(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha3_384(): ByteArray = DigestUtils.sha3_384(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha3_512(): ByteArray = DigestUtils.sha3_512(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha384(): ByteArray = DigestUtils.sha384(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha512(): ByteArray = DigestUtils.sha512(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha512_224(): ByteArray = DigestUtils.sha512_224(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.sha512_256(): ByteArray = DigestUtils.sha512_256(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.toString(charset: Charset): String = IOUtils.toString(this, charset)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.toByteArray(): ByteArray = IOUtils.toByteArray(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.toByteArray(size: Long) = IOUtils.toByteArray(this, size)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.toCharArray(charset: Charset = Charsets.UTF_8) = IOUtils.toCharArray(this, charset)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun InputStream.equal(inputStream: InputStream): Boolean = IOUtils.contentEquals(this, inputStream)
