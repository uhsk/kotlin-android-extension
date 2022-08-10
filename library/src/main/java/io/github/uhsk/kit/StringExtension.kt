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

import io.github.uhsk.kit.utils.ByteArrayBase64Util
import org.apache.commons.codec.binary.Hex
import java.io.File
import java.nio.charset.Charset

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.md5(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toByteArray(charset).hash().md5().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.sha1(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toByteArray(charset).hash().sha1().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.sha256(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toByteArray(charset).hash().sha256().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.sha512(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toByteArray(charset).hash().sha512().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.base64(charset: Charset = Charsets.UTF_8): ByteArrayBase64Util = ByteArrayBase64Util(bytes = this.toByteArray(charset))

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.asFile(): File = File(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.asHexStringToByteArray(): ByteArray = Hex.decodeHex(this)
