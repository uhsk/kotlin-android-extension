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
import org.apache.commons.lang3.StringUtils
import java.io.File
import java.nio.charset.Charset

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.uuid(charset: Charset = Charsets.UTF_8): CharSequence = this.toString().toByteArray(charset).hash().uuid().toString()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.md5(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toString().toByteArray(charset).hash().md5().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.sha1(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toString().toByteArray(charset).hash().sha1().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.sha256(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toString().toByteArray(charset).hash().sha256().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.sha512(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toString().toByteArray(charset).hash().sha512().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.base64(charset: Charset = Charsets.UTF_8): ByteArrayBase64Util = ByteArrayBase64Util(bytes = this.toString().toByteArray(charset))

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.toFile(): File = File(this.toString())

/**
 * @since 1.0.0
 * @author sollyu
 * @see Hex.decodeHex
 */
fun CharSequence.asHexStringToByteArray(): ByteArray = Hex.decodeHex(this.toString())

/**
 * @since 1.0.2
 * @author sollyu
 * @see org.apache.commons.lang3.StringUtils.abbreviate
 */
fun CharSequence.abbreviate(width: Int): CharSequence = this.toString().abbreviate(width)

/**
 * @since 1.0.2
 * @author sollyu
 * @see StringUtils.center
 */
fun CharSequence.center(size: Int, pad: String = " "): CharSequence = this.toString().center(size, pad)

/**
 * @since 1.0.2
 * @author sollyu
 * @see StringUtils.chomp
 */
fun CharSequence.chomp(): CharSequence = this.toString().chomp()

/**
 * @since 1.0.2
 * @author sollyu
 */
fun CharSequence.find(regex: Regex, startIndex: Int = 0): MatchResult? = regex.find(this, startIndex)
